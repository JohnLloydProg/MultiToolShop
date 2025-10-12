package com.unida.multitoolshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unida.multitoolshop.model.MultiToolOption;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class MultiToolSetOptionData {

    @EmbeddedId
    private SetOptionId id = new SetOptionId();

    @ManyToOne
    @MapsId("multiToolSetDataId")
    @JoinColumn(name = "multiToolSetData_id")
    private MultiToolSetData multiToolSetData;

    @ManyToOne
    @MapsId("multToolOptionDataId")
    @JoinColumn(name = "multiToolOptionData_id")
    private MultiToolOptionData multiToolOption;

    private Float addedPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updated;

}
