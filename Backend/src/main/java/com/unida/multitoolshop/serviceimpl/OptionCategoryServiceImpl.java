package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.OptionCategoryData;
import com.unida.multitoolshop.model.OptionCategory;
import com.unida.multitoolshop.repository.OptionCategoryDataRepository;
import com.unida.multitoolshop.service.OptionCategoryService;
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
public class OptionCategoryServiceImpl implements OptionCategoryService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    OptionCategoryDataRepository optionCategoryDataRepository;


    @Override
    public List<OptionCategory> getAll() {
        List<OptionCategory> optionCategoryList = new ArrayList<>();
        for (OptionCategoryData optionCategoryData : optionCategoryDataRepository.findAll()) {
            optionCategoryList.add(Transformer.convert(optionCategoryData));
        }
        logger.info("Returned OptionCategory list with length of " + optionCategoryList.size());
        return optionCategoryList;
    }

    @Override
    public OptionCategory create(OptionCategory optionCategory) {
        OptionCategoryData optionCategoryData = Transformer.convert(optionCategory);
        OptionCategory newOptionCategory = Transformer.convert(optionCategoryDataRepository.save(optionCategoryData));
        logger.info("Created OptionCategory with id " + newOptionCategory.getId());
        return newOptionCategory;
    }

    @Override
    public void delete(Integer id) {
        Optional<OptionCategoryData> optionCategoryData = optionCategoryDataRepository.findById(id);
        if (optionCategoryData.isPresent()) {
            logger.info("Deleted OptionCategory with id " + optionCategoryData.get().getId());
            optionCategoryDataRepository.delete(optionCategoryData.get());
        }else {
            logger.info("Can't find OptionCategory with id " + id);
        }
    }
}
