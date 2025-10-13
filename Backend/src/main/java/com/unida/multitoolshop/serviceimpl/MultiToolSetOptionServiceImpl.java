package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolSetOptionData;
import com.unida.multitoolshop.entity.SetOptionId;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.MultiToolSetOption;
import com.unida.multitoolshop.repository.MultiToolSetOptionDataRepository;
import com.unida.multitoolshop.service.MultiToolSetOptionService;
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
public class MultiToolSetOptionServiceImpl implements MultiToolSetOptionService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolSetOptionDataRepository multiToolSetOptionDataRepository;

    @Override
    public List<MultiToolSetOption> getAllBySet(MultiToolSet multiToolSet) {
        List<MultiToolSetOption> multiToolSetOptionList = new ArrayList<>();
        for (MultiToolSetOptionData multiToolSetOptionData : multiToolSetOptionDataRepository.findAll()) {
            multiToolSetOptionList.add(Transformer.convert(multiToolSetOptionData));
        }
        logger.info("Returned list of MultiToolSetOption with length of " + multiToolSetOptionList.size());
        return multiToolSetOptionList;
    }

    @Override
    public MultiToolSetOption getById(SetOptionId setOptionId) {
        Optional<MultiToolSetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(setOptionId);
        if (multiToolSetOptionData.isPresent()) {
            return Transformer.convert(multiToolSetOptionData.get());
        }else {
            logger.info("Can't find MultiToolSetOption with id " + setOptionId);
        }
        return null;
    }

    @Override
    public MultiToolSetOption create(MultiToolSetOption multiToolSetOption) {
        MultiToolSetOptionData multiToolSetOptionData = Transformer.convert(multiToolSetOption);
        MultiToolSetOption newMultiToolSetOption = Transformer.convert(multiToolSetOptionDataRepository.save(multiToolSetOptionData));
        logger.info("Created MultiToolSetOption with id " + newMultiToolSetOption.getId());
        return newMultiToolSetOption;
    }

    @Override
    public MultiToolSetOption update(MultiToolSetOption multiToolSetOption) {
        MultiToolSetOptionData multiToolSetOptionData = Transformer.convert(multiToolSetOption);
        MultiToolSetOption newMultiToolSetOption = Transformer.convert(multiToolSetOptionDataRepository.save(multiToolSetOptionData));
        logger.info("Updated MultiToolSetOption with id " + newMultiToolSetOption.getId());
        return newMultiToolSetOption;
    }

    @Override
    public void delete(SetOptionId id) {
        Optional<MultiToolSetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(id);
        if (multiToolSetOptionData.isPresent()) {
            logger.info("Deleted MultiToolSetOption with id " + multiToolSetOptionData.get().getId());
            multiToolSetOptionDataRepository.delete(multiToolSetOptionData.get());
        }else {
            logger.info("Can't find MultiToolSetOption with id " + id);
        }
    }
}
