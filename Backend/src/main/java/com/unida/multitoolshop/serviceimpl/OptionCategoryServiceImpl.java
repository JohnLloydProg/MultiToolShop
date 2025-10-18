package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.OptionCategoryData;
import com.unida.multitoolshop.model.OptionCategory;
import com.unida.multitoolshop.repository.OptionCategoryDataRepository;
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
public class OptionCategoryServiceImpl implements OptionCategoryService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    OptionCategoryDataRepository optionCategoryDataRepository;

    private OptionCategory convert(OptionCategoryData optionCategoryData) {
        OptionCategory optionCategory = new OptionCategory();
        optionCategory.setId(optionCategoryData.getId());
        optionCategory.setName(optionCategoryData.getName());
        optionCategory.setCreated(optionCategoryData.getCreated());
        return optionCategory;
    }

    private OptionCategoryData convert(OptionCategory optionCategory) {
        OptionCategoryData optionCategoryData = new OptionCategoryData();
        optionCategoryData.setId(optionCategory.getId());
        optionCategoryData.setName(optionCategory.getName());
        optionCategoryData.setCreated(optionCategory.getCreated());
        return optionCategoryData;
    }

    @Override
    public OptionCategory getById(int id) {
        Optional<OptionCategoryData> optionCategoryData = optionCategoryDataRepository.findById(id);
        if (optionCategoryData.isPresent()) {
            logger.info("Returned OptionCategory with id " + id);
            return this.convert(optionCategoryData.get());
        }
        return null;
    }

    @Override
    public List<OptionCategory> getAll() {
        List<OptionCategory> optionCategoryList = new ArrayList<>();
        for (OptionCategoryData optionCategoryData : optionCategoryDataRepository.findAll()) {
            optionCategoryList.add(this.convert(optionCategoryData));
        }
        logger.info("Returned OptionCategory list with length of " + optionCategoryList.size());
        return optionCategoryList;
    }

    @Override
    public OptionCategory create(OptionCategory optionCategory) {
        OptionCategoryData optionCategoryData = this.convert(optionCategory);
        OptionCategory newOptionCategory = this.convert(optionCategoryDataRepository.save(optionCategoryData));
        logger.info("Created OptionCategory with id " + newOptionCategory.getId());
        return newOptionCategory;
    }

    @Override
    public void delete(int id) {
        Optional<OptionCategoryData> optionCategoryData = optionCategoryDataRepository.findById(id);
        if (optionCategoryData.isPresent()) {
            logger.info("Deleted OptionCategory with id " + optionCategoryData.get().getId());
            optionCategoryDataRepository.delete(optionCategoryData.get());
        }else {
            logger.info("Can't find OptionCategory with id " + id);
        }
    }
}
