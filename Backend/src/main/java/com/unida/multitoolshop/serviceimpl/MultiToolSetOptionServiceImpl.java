package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolOptionData;
import com.unida.multitoolshop.entity.MultiToolSetData;
import com.unida.multitoolshop.entity.MultiToolSetOptionData;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.MultiToolSetOption;
import com.unida.multitoolshop.repository.MultiToolOptionDataRepository;
import com.unida.multitoolshop.repository.MultiToolSetDataRepository;
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

    @Autowired
    MultiToolSetDataRepository multiToolSetDataRepository;

    @Autowired
    MultiToolOptionDataRepository multiToolOptionDataRepository;

    @Override
    public List<MultiToolSetOption> getAllBySetId(int setId) {
        List<MultiToolSetOption> multiToolSetOptionList = new ArrayList<>();
        for (MultiToolSetOptionData multiToolSetOptionData : multiToolSetOptionDataRepository.findAll()) {
            if (multiToolSetOptionData.getSetId() == setId) {
                MultiToolSetOption multiToolSetOption = Transformer.convert(multiToolSetOptionData);
                Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(multiToolSetOptionData.getSetId());
                Optional<MultiToolOptionData> multiToolOptionData = multiToolOptionDataRepository.findById(multiToolSetOptionData.getOptionId());
                if (multiToolSetData.isPresent() && multiToolOptionData.isPresent()) {
                    multiToolSetOption.setMultiToolOption(Transformer.convert(multiToolOptionData.get()));
                    multiToolSetOption.setMultiToolSet(Transformer.convert(multiToolSetData.get()));
                    multiToolSetOptionList.add(multiToolSetOption);
                }

            }
        }
        logger.info("Returned list of MultiToolSetOption with length of " + multiToolSetOptionList.size());
        return multiToolSetOptionList;
    }

    @Override
    public MultiToolSetOption getById(int id) {
        Optional<MultiToolSetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(id);
        if (multiToolSetOptionData.isPresent()) {
            MultiToolSetOption multiToolSetOption = Transformer.convert(multiToolSetOptionData.get());
            Optional<MultiToolSetData> multiToolSetData = multiToolSetDataRepository.findById(multiToolSetOptionData.get().getSetId());
            Optional<MultiToolOptionData> multiToolOptionData = multiToolOptionDataRepository.findById(multiToolSetOptionData.get().getOptionId());
            if (multiToolSetData.isPresent() && multiToolOptionData.isPresent()) {
                multiToolSetOption.setMultiToolSet(Transformer.convert(multiToolSetData.get()));
                multiToolSetOption.setMultiToolOption(Transformer.convert(multiToolOptionData.get()));
                return multiToolSetOption;
            }
        }else {
            logger.info("Can't find MultiToolSetOption with id " + id);
        }
        return null;
    }

    @Override
    public MultiToolSetOption create(MultiToolSetOption multiToolSetOption) {
        logger.info("INPUT>> setId: " + multiToolSetOption.getMultiToolSet().getId() + ", option id " + multiToolSetOption.getMultiToolOption().getId());
        MultiToolSetOptionData multiToolSetOptionData = Transformer.convert(multiToolSetOption);
        multiToolSetOptionData.setOptionId(multiToolSetOption.getMultiToolOption().getId());
        multiToolSetOptionData.setSetId(multiToolSetOption.getMultiToolSet().getId());
        MultiToolSetOption newMultiToolSetOption = Transformer.convert(multiToolSetOptionDataRepository.save(multiToolSetOptionData));
        logger.info("Created MultiToolSetOption with id " + newMultiToolSetOption.getId());
        return newMultiToolSetOption;
    }

    @Override
    public MultiToolSetOption update(MultiToolSetOption multiToolSetOption) {
        MultiToolSetOptionData multiToolSetOptionData = Transformer.convert(multiToolSetOption);
        multiToolSetOptionData.setOptionId(multiToolSetOption.getMultiToolOption().getId());
        multiToolSetOptionData.setSetId(multiToolSetOption.getMultiToolSet().getId());
        MultiToolSetOption newMultiToolSetOption = Transformer.convert(multiToolSetOptionDataRepository.save(multiToolSetOptionData));
        logger.info("Updated MultiToolSetOption with id " + newMultiToolSetOption.getId());
        return newMultiToolSetOption;
    }

    @Override
    public void delete(int id) {
        Optional<MultiToolSetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(id);
        if (multiToolSetOptionData.isPresent()) {
            logger.info("Deleted MultiToolSetOption with id " + multiToolSetOptionData.get().getId());
            multiToolSetOptionDataRepository.delete(multiToolSetOptionData.get());
        }else {
            logger.info("Can't find MultiToolSetOption with id " + id);
        }
    }
}
