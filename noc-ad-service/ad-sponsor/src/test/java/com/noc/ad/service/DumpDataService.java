package com.noc.ad.service;

import com.alibaba.fastjson.JSON;
import com.noc.ad.SponsorApplicationTests;
import com.noc.ad.constant.CommonStatus;
import com.noc.ad.dao.AdPlanRepository;
import com.noc.ad.dao.AdUnitRepository;
import com.noc.ad.dao.CreativeRepository;
import com.noc.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.noc.ad.dao.unit_condition.AdUnitItRepository;
import com.noc.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.noc.ad.dao.unit_condition.CreativeUnitRepository;
import com.noc.ad.dump.DConstant;
import com.noc.ad.dump.table.*;
import com.noc.ad.entity.AdPlan;
import com.noc.ad.entity.AdUnit;
import com.noc.ad.entity.Creative;
import com.noc.ad.entity.unit_condition.AdUnitDistrict;
import com.noc.ad.entity.unit_condition.AdUnitIt;
import com.noc.ad.entity.unit_condition.AdUnitKeyword;
import com.noc.ad.entity.unit_condition.CreativeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据导出服务
 */
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

    @Test
    public void dumpAdTableData() {
        dumpAdPlanTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdUnitTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdCreativeTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdCreativeUnitTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdUnitDistrictTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdUnitItTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        dumpAdUnitKeywordTable(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
    }

    private void dumpAdPlanTable(String fileName) {
        List<AdPlan> adPlans = planRepository.findAllByPlanStatus(CommonStatus.VALID.getStatus());
        if (CollectionUtils.isEmpty(adPlans)) {
            return;
        }
        List<AdPlanTable> adPlanTables = new ArrayList<>();
        adPlans.forEach(p -> adPlanTables.add(new AdPlanTable(p.getId(), p.getUserId(), p.getPlanStatus(),
                p.getStartDate(), p.getEndDate())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdPlanTable adPlanTable : adPlanTables) {
                bufferedWriter.write(JSON.toJSONString(adPlanTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdPlanTable error:" + e.getMessage());
        }
    }

    private void dumpAdUnitTable(String fileName) {
        List<AdUnit> adUnits = unitRepository.findAllByUnitStatus(CommonStatus.VALID.getStatus());
        if (CollectionUtils.isEmpty(adUnits)) {
            return;
        }
        List<AdUnitTable> adUnitTables = new ArrayList<>();
        adUnits.forEach(p -> adUnitTables.add(new AdUnitTable(p.getId(), p.getUnitStatus(), p.getPositionType(), p.getPlanId())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdUnitTable adUnitTable : adUnitTables) {
                bufferedWriter.write(JSON.toJSONString(adUnitTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdUnitTable error:" + e.getMessage());
        }
    }

    private void dumpAdCreativeTable(String fileName) {
        List<Creative> creatives = creativeRepository.findAll();
        if (CollectionUtils.isEmpty(creatives)) {
            return;
        }
        List<AdCreativeTable> adCreativeTables = new ArrayList<>();
        creatives.forEach(p -> adCreativeTables.add(new AdCreativeTable(p.getId(), p.getName(), p.getType(), p.getMaterialType(),
                p.getHeight(), p.getWidth(), p.getAuditStatus(), p.getUrl())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdCreativeTable adCreativeTable : adCreativeTables) {
                bufferedWriter.write(JSON.toJSONString(adCreativeTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdCreativeTable error:" + e.getMessage());
        }
    }

    private void dumpAdCreativeUnitTable(String fileName) {
        List<CreativeUnit> creativeUnits = creativeUnitRepository.findAll();
        if (CollectionUtils.isEmpty(creativeUnits)) {
            return;
        }
        List<AdCreativeUnitTable> adCreativeUnitTables = new ArrayList<>();
        creativeUnits.forEach(p -> adCreativeUnitTables.add(new AdCreativeUnitTable(p.getCreativeId(), p.getUnitId())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdCreativeUnitTable adCreativeUnitTable : adCreativeUnitTables) {
                bufferedWriter.write(JSON.toJSONString(adCreativeUnitTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdCreativeUnitTable error:" + e.getMessage());
        }
    }

    private void dumpAdUnitDistrictTable(String fileName) {
        List<AdUnitDistrict> adUnitDistricts = districtRepository.findAll();
        if (CollectionUtils.isEmpty(adUnitDistricts)) {
            return;
        }
        List<AdUnitDistrictTable> adUnitDistrictTables = new ArrayList<>();
        adUnitDistricts.forEach(p -> adUnitDistrictTables.add(new AdUnitDistrictTable(p.getUnitId(), p.getProvince(),
                p.getCity())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdUnitDistrictTable adUnitDistrictTable : adUnitDistrictTables) {
                bufferedWriter.write(JSON.toJSONString(adUnitDistrictTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdUnitDistrictTable error:" + e.getMessage());
        }
    }

    private void dumpAdUnitItTable(String fileName) {
        List<AdUnitIt> unitIts = itRepository.findAll();
        if (CollectionUtils.isEmpty(unitIts)) {
            return;
        }
        List<AdUnitItTable> adUnitItTables = new ArrayList<>();
        unitIts.forEach(p -> adUnitItTables.add(new AdUnitItTable(p.getUnitId(), p.getItTag())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdUnitItTable adUnitItTable : adUnitItTables) {
                bufferedWriter.write(JSON.toJSONString(adUnitItTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdUnitDistrictTable error:" + e.getMessage());
        }
    }


    private void dumpAdUnitKeywordTable(String fileName) {
        List<AdUnitKeyword> unitKeywords = keywordRepository.findAll();
        if (CollectionUtils.isEmpty(unitKeywords)) {
            return;
        }
        List<AdUnitKeywordTable> adUnitKeywordTables = new ArrayList<>();
        unitKeywords.forEach(p -> adUnitKeywordTables.add(new AdUnitKeywordTable(p.getUnitId(), p.getKeyword())));
        Path path = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AdUnitKeywordTable adUnitKeywordTable : adUnitKeywordTables) {
                bufferedWriter.write(JSON.toJSONString(adUnitKeywordTable));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            log.error("dumpAdUnitDistrictTable error:" + e.getMessage());
        }
    }
}
