package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.MultiToolOptionData;
import com.unida.multitoolshop.entity.MultiToolSetData;
import com.unida.multitoolshop.entity.SetOptionData;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.SetOption;
import com.unida.multitoolshop.repository.SetOptionDataRepository;
import com.unida.multitoolshop.service.MultiToolOptionService;
import com.unida.multitoolshop.service.MultiToolSetService;
import com.unida.multitoolshop.service.SetOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class SetOptionServiceImpl implements SetOptionService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    SetOptionDataRepository multiToolSetOptionDataRepository;

    @Autowired
    MultiToolOptionService multiToolOptionService;

    private SetOption convert(SetOptionData setOptionData) {
        SetOption setOption = new SetOption();
        setOption.setId(setOptionData.getId());
        setOption.setAddedPrice(setOptionData.getAddedPrice());
        setOption.setCreated(setOptionData.getCreated());
        setOption.setUpdated(setOptionData.getUpdated());
        setOption.setSetId(setOptionData.getSetId());
        MultiToolOption multiToolOption = multiToolOptionService.getById(setOptionData.getOptionId());
        if (multiToolOption != null) {
            setOption.setMultiToolOption(multiToolOption);
        }
        return setOption;
    }

    private SetOptionData convert(SetOption setOption) {
        SetOptionData setOptionData = new SetOptionData();
        setOptionData.setId(setOption.getId());
        setOptionData.setAddedPrice(setOption.getAddedPrice());
        setOptionData.setCreated(setOption.getCreated());
        setOptionData.setUpdated(setOption.getUpdated());
        setOptionData.setSetId(setOption.getSetId());
        setOptionData.setOptionId(setOption.getMultiToolOption().getId());
        return setOptionData;
    }

    @Override
    public List<SetOption> getAll() {
        List<SetOption> setOptionList = new ArrayList<>();
        for (SetOptionData setOptionData : multiToolSetOptionDataRepository.findAll()) {
            setOptionList.add(this.convert(setOptionData));
        }
        return setOptionList;
    }

    @Override
    public List<SetOption> getAllBySetId(int setId) {
        List<SetOption> setOptionList = new ArrayList<>();
        for (SetOptionData setOptionData : multiToolSetOptionDataRepository.findAll()) {
            if (setOptionData.getSetId() == setId) {
                setOptionList.add(this.convert(setOptionData));
            }
        }
        logger.info("Returned list of MultiToolSetOption with length of " + setOptionList.size());
        return setOptionList;
    }

    @Override
    public SetOption getById(int id) {
        Optional<SetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(id);
        if (multiToolSetOptionData.isPresent()) {
            return this.convert(multiToolSetOptionData.get());

        }else {
            logger.info("Can't find MultiToolSetOption with id " + id);
        }
        return null;
    }

    @Override
    public SetOption create(SetOption setOption) {
        SetOptionData setOptionData = this.convert(setOption);
        SetOption newSetOption = this.convert(multiToolSetOptionDataRepository.save(setOptionData));
        logger.info("Created MultiToolSetOption with id " + newSetOption.getId());
        return newSetOption;
    }

    @Override
    public SetOption update(SetOption setOption) {
        SetOptionData setOptionData = this.convert(setOption);
        SetOption newSetOption = this.convert(multiToolSetOptionDataRepository.save(setOptionData));
        logger.info("Updated MultiToolSetOption with id " + newSetOption.getId());
        return newSetOption;
    }

    @Override
    public void delete(int id) {
        Optional<SetOptionData> multiToolSetOptionData = multiToolSetOptionDataRepository.findById(id);
        if (multiToolSetOptionData.isPresent()) {
            logger.info("Deleted MultiToolSetOption with id " + multiToolSetOptionData.get().getId());
            multiToolSetOptionDataRepository.delete(multiToolSetOptionData.get());
        }else {
            logger.info("Can't find MultiToolSetOption with id " + id);
        }
    }
}
