package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolSetData;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.repository.MultiToolSetDataRepository;
import com.unida.multitoolshop.service.MultiToolSetService;
import lombok.extern.slf4j.Slf4j;
import org.apache.xpath.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class MultiToolSetServiceImpl implements MultiToolSetService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolSetDataRepository multiToolSetDataRepository;

    private MultiToolSet convert(MultiToolSetData multiToolSetData) {
        MultiToolSet multiToolSet = new MultiToolSet();
        multiToolSet.setId(multiToolSetData.getId());
        multiToolSet.setName(multiToolSetData.getName());
        multiToolSet.setDescription(multiToolSetData.getDescription());
        multiToolSet.setImage(multiToolSetData.getImage());
        multiToolSet.setBasePrice(multiToolSetData.getBasePrice());
        multiToolSet.setOrders(multiToolSetData.getOrders());
        multiToolSet.setStock(multiToolSetData.getStock());
        multiToolSet.setCreated(multiToolSetData.getCreated());
        multiToolSet.setUpdated(multiToolSetData.getUpdated());
        multiToolSet.setCustomizations(multiToolSetData.getCustomizations());
        return multiToolSet;
    }

    private MultiToolSetData convert(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = new MultiToolSetData();
        multiToolSetData.setId(multiToolSet.getId());
        multiToolSetData.setName(multiToolSet.getName());
        multiToolSetData.setDescription(multiToolSet.getDescription());
        multiToolSetData.setImage(multiToolSet.getImage());
        multiToolSetData.setOrders(multiToolSet.getOrders());
        multiToolSetData.setStock(multiToolSet.getStock());
        multiToolSetData.setBasePrice(multiToolSet.getBasePrice());
        multiToolSetData.setCreated(multiToolSet.getCreated());
        multiToolSetData.setUpdated(multiToolSet.getUpdated());
        multiToolSetData.setCustomizations(multiToolSet.getCustomizations());
        return multiToolSetData;
    }

    @Override
    public List<MultiToolSet> getAll() {
        List<MultiToolSet> multiToolSetList = new ArrayList<>();
        for (MultiToolSetData multiToolSetData : multiToolSetDataRepository.findAll()) {
            multiToolSetList.add(this.convert(multiToolSetData));
        }
        logger.info("Returned list of MultiToolSet with length of" + multiToolSetList.size());
        return multiToolSetList;
    }

    @Override
    public List<MultiToolSet> getMostPopular(int length) {
        List<MultiToolSet> multiToolSetList = new ArrayList<>();
        Iterator<MultiToolSetData> iterator = multiToolSetDataRepository.findAll().iterator();
        for (int i = 0; i < length && iterator.hasNext(); i++) {
            MultiToolSetData multiToolSetData = iterator.next();
            multiToolSetList.add(this.convert(multiToolSetData));
        }
        multiToolSetList.sort(((o1, o2) -> Integer.compare(o2.getOrders(), o1.getOrders())));
        return multiToolSetList;
    }

    @Override
    public MultiToolSet getById(int id) {
        Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(id);
        if (multiToolSetData.isPresent()) {
            return this.convert(multiToolSetData.get());
        }else {
            logger.info("Can't find MultiToolSet with id of " + id);
        }
        return null;
    }

    @Override
    public MultiToolSet create(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = this.convert(multiToolSet);
        MultiToolSet newMultiToolSet = this.convert(multiToolSetDataRepository.save(multiToolSetData));
        logger.info("Created MultitoolSet with id " + newMultiToolSet.getId());
        return newMultiToolSet;
    }

    @Override
    public MultiToolSet update(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = this.convert(multiToolSet);
        MultiToolSet newMultiToolSet = this.convert(multiToolSetDataRepository.save(multiToolSetData));
        logger.info("Updated MultiToolSet with id" + newMultiToolSet.getId());
        return newMultiToolSet;
    }

    @Override
    public void delete(int id) {
        Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(id);
        if (multiToolSetData.isPresent()) {
            logger.info("Deleted MultiToolSet with id " + multiToolSetData.get().getId());
            multiToolSetDataRepository.delete(multiToolSetData.get());
        }else {
            logger.info("No MultiToolSet with id " + id);
        }
    }
}
