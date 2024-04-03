/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafexamples.stsm.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import thymeleafexamples.stsm.business.entities.Feature;
import thymeleafexamples.stsm.business.entities.Phone;
import thymeleafexamples.stsm.business.entities.Type;
import thymeleafexamples.stsm.business.entities.Variety;
import thymeleafexamples.stsm.business.services.PhoneService;
import thymeleafexamples.stsm.business.services.VarietyService;


@Controller
public class SeedStarterMngController {


    private static final String INDEX_PAGE = "seedstartermng";

	@Autowired
    private VarietyService varietyService;
    
    @Autowired
    private PhoneService phoneService;

    @Value("${key}")
    private String key;
    
    @Value("${name}")
    private String name;
    
    public SeedStarterMngController() {
        super();
    }

    
    
    @ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return Arrays.asList(Type.ALL);
    }
    
    @ModelAttribute("allFeatures")
    public List<Feature> populateFeatures() {
        return Arrays.asList(Feature.ALL);
    }
    
    @ModelAttribute("allVarieties")
    public List<Variety> populateVarieties() {
        return this.varietyService.findAll();
    }
    
    @ModelAttribute("allSeedStarters")
    public List<Phone> populateSeedStarters() {
    	List<Phone> phones = this.phoneService.findAll();
    	if(phones == null || phones.size()==0) {
    		this.phoneService.seed();
    	}
        return this.phoneService.findAll();
    }
    
    @ModelAttribute("key")
    public String key() {
    	System.out.println("KEY =====>>> " + this.key);
        return this.key;
    }
    
    @ModelAttribute("name")
    public String name() {
    	System.out.println("NAME =====>>> " + this.name);
        return this.name;
    }
    
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String testApp() throws Exception{
        return INDEX_PAGE;
    }

}
