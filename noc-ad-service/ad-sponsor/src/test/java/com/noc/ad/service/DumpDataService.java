package com.noc.ad.service;

import com.noc.ad.SponsorApplicationTests;
import com.noc.ad.dao.AdPlanRepository;
import com.noc.ad.dao.AdUnitRepository;
import com.noc.ad.dao.CreativeRepository;
import com.noc.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.noc.ad.dao.unit_condition.AdUnitItRepository;
import com.noc.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.noc.ad.dao.unit_condition.CreativeUnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class DumpDataService extends SponsorApplicationTests {

    @Autowired
    private AdPlanRepository planRepository;
    @Autowired
    private AdUnitRepository unitRepository;
    @Autowired
    private CreativeRepository creativeRepository;
    @Autowired
    private CreativeUnitRepository creativeUnitRepository;
    @Autowired
    private AdUnitDistrictRepository districtRepository;
    @Autowired
    private AdUnitItRepository itRepository;
    @Autowired
    private AdUnitKeywordRepository keywordRepository;

}
