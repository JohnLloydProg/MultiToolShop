package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolOptionData;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.OptionCategory;
import com.unida.multitoolshop.repository.MultiToolOptionDataRepository;
import com.unida.multitoolshop.service.MultiToolOptionService;
import com.unida.multitoolshop.service.OptionCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class MultiToolOptionServiceImpl implements MultiToolOptionService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolOptionDataRepository multiToolOptionDataRepository;

    @Autowired
    OptionCategoryService optionCategoryService;

    private MultiToolOption convert(MultiToolOptionData multiToolOptionData) {
        MultiToolOption multiToolOption = new MultiToolOption();
        multiToolOption.setId(multiToolOptionData.getId());
        multiToolOption.setName(multiToolOptionData.getName());
        multiToolOption.setCreated(multiToolOptionData.getCreated());
        multiToolOption.setUpdated(multiToolOptionData.getUpdated());
        OptionCategory optionCategory = optionCategoryService.getById(multiToolOptionData.getCategoryId());
        if (optionCategory != null) {
            multiToolOption.setCategoryId(optionCategory.getId());
            multiToolOption.setCategoryName(optionCategory.getName());
            multiToolOption.setMultiple(optionCategory.isMultiple());
        }
        return multiToolOption;
    }

    private MultiToolOptionData convert(MultiToolOption multiToolOption) {
        MultiToolOptionData multiToolOptionData = new MultiToolOptionData();
        multiToolOptionData.setId(multiToolOption.getId());
        multiToolOptionData.setName(multiToolOption.getName());
        multiToolOptionData.setCreated(multiToolOption.getCreated());
        multiToolOptionData.setUpdated(multiToolOption.getUpdated());
        multiToolOptionData.setCategoryId(multiToolOption.getCategoryId());
        return multiToolOptionData;
    }

    @Override
    public List<MultiToolOption> getAll() {
        List<MultiToolOption> multiToolOptionList = new ArrayList<>();
        for (MultiToolOptionData multiToolOptionData : multiToolOptionDataRepository.findAll()) {
            multiToolOptionList.add(this.convert(multiToolOptionData));
        }
        logger.info("Returned list of MultiToolOption with length of" + multiToolOptionList.size());
        return multiToolOptionList;
    }

    @Override
    public MultiToolOption getById(int id) {
        Optional<MultiToolOptionData> multiToolOptionData = multiToolOptionDataRepository.findById(id);
        if (multiToolOptionData.isPresent()) {
            logger.info("Returned MultiToolOption with id " + id);
            return this.convert(multiToolOptionData.get());
        }
        return null;
    }

    @Override
    public MultiToolOption create(MultiToolOption multiToolOption) {
        MultiToolOptionData multiToolOptionData = this.convert(multiToolOption);
        MultiToolOption newMultiToolOption = this.convert(multiToolOptionDataRepository.save(multiToolOptionData));
        logger.info("Created a new MultiToolOption with id " + newMultiToolOption.getId());
        return newMultiToolOption;
    }

    @Override
    public MultiToolOption update(MultiToolOption multiToolOption) {
        MultiToolOptionData multiToolOptionData = this.convert(multiToolOption);
        MultiToolOption newMultiToolOption = this.convert(multiToolOptionDataRepository.save(multiToolOptionData));
        logger.info("Updated the MultiToolOption with id " + newMultiToolOption.getId());
        return newMultiToolOption;
    }

    @Override
    public void delete(int id) {
        Optional<MultiToolOptionData> multiToolOptionData = multiToolOptionDataRepository.findById(id);
        if (multiToolOptionData.isPresent()) {
            logger.info("Deleted the MultiToolOption with id " + multiToolOptionData.get().getId());
            multiToolOptionDataRepository.delete(multiToolOptionData.get());
        }else {
            logger.info("No MultiToolOption with id " + id);
        }
    }
}
