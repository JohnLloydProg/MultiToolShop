package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolSetData;
import com.unida.multitoolshop.entity.MultiToolSetOptionData;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.repository.MultiToolSetDataRepository;
import com.unida.multitoolshop.service.MultiToolSetService;
import com.unida.multitoolshop.util.Transformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class MultiToolSetServiceImpl implements MultiToolSetService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolSetDataRepository multiToolSetDataRepository;

    @Override
    public List<MultiToolSet> getAll() {
        List<MultiToolSet> multiToolSetList = new ArrayList<>();
        for (MultiToolSetData multiToolSetData : multiToolSetDataRepository.findAll()) {
            multiToolSetList.add(Transformer.convert(multiToolSetData));
        }
        logger.info("Returned list of MultiToolSet with length of" + multiToolSetList.size());
        return multiToolSetList;
    }

    @Override
    public MultiToolSet getById(Integer id) {
        Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(id);
        if (multiToolSetData.isPresent()) {
            return Transformer.convert(multiToolSetData.get());
        }else {
            logger.info("Can't find MultiToolSet with id of " + id);
        }
        return null;
    }

    @Override
    public MultiToolSet create(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = Transformer.convert(multiToolSet);
        MultiToolSet newMultiToolSet = Transformer.convert(multiToolSetDataRepository.save(multiToolSetData));
        logger.info("Created MultitoolSet with id " + newMultiToolSet.getId());
        return newMultiToolSet;
    }

    @Override
    public MultiToolSet update(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = Transformer.convert(multiToolSet);
        MultiToolSet newMultiToolSet = Transformer.convert(multiToolSetDataRepository.save(multiToolSetData));
        logger.info("Updated MultiToolSet with id" + newMultiToolSet.getId());
        return newMultiToolSet;
    }

    @Override
    public void delete(Integer id) {
        Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(id);
        if (multiToolSetData.isPresent()) {
            logger.info("Deleted MultiToolSet with id " + multiToolSetData.get().getId());
            multiToolSetDataRepository.delete(multiToolSetData.get());
        }else {
            logger.info("No MultiToolSet with id " + id);
        }
    }
}
