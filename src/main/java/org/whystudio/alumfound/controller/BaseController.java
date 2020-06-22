package org.whystudio.alumfound.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.whystudio.alumfound.annotation.Cross;
import org.whystudio.alumfound.service.*;

/**
 * Controller中的公共信息可以提取出来
 * @author qkmc
 */
@Cross
public abstract class BaseController {

    @Autowired
    IElsepubinfoService elsepubinfoService;

    @Autowired
    IBeneficiaryService beneficiaryService;

    @Autowired
    IDonationlistService donationlistService;

    @Autowired
    IYearlyreportService yearlyreportService;

    @Autowired
    IDonationprojectService donationprojectService;

    @Autowired
    IDonationinfoService donationinfoService;

    @Autowired
    ILawregulationService lawregulationService;

    @Autowired
    IAlumniinfoService alumniinfoService;

    @Autowired
    IAlumnimienService alumnimienService;

    @Autowired
    IBannerService bannerService;

    @Autowired
    IFileService fileService;

    @Autowired
    IManagesystemService managesystemService;

    @Autowired
    INewsService newsService;

    @Autowired
    IPicnewsService picnewsService;

}
