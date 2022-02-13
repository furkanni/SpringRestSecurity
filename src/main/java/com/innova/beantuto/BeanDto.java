package com.innova.beantuto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BeanDto {

    private Long id;
    private String beanName;
    private String beanData;

    //başlangıç

    public void initialBEanMethod(){
        log.info("Bean Başladı");
        System.out.println("Bean başladı");
        //database vs kim başlattı
    }

    //bitiş

    public void destroyBEanMethod(){
        log.error("Bean Öldü");
        System.err.println("Bean öldü");
        //loglama için kim bitirdi vs
    }

}
