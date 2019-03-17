package com.noc.ad.service;


import com.noc.ad.vo.CreativeRequest;
import com.noc.ad.vo.CreativeResponse;

public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
