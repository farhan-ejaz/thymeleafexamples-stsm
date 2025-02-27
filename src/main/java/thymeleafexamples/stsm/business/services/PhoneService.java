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
package thymeleafexamples.stsm.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thymeleafexamples.stsm.business.entities.Phone;
import thymeleafexamples.stsm.business.entities.repositories.PhoneRepository;

@Service
public class PhoneService {
    
    @Autowired
    private PhoneRepository phoneRepository; 
    
    
    public PhoneService() {
        super();
    }
    
    public List<Phone> findAll() {
        return this.phoneRepository.findAll();
    }
    
    public void seed() {
    	this.phoneRepository.insert();
    }
}
