package com.csokoli.linkbib.controller;

import com.csokoli.linkbib.domain.Site;
import com.csokoli.linkbib.exception.SiteNotFoundException;
import com.csokoli.linkbib.repository.SiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/data/")
public class SiteController {

    private SiteRepository siteRepository;

    public SiteController(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @GetMapping
    @CrossOrigin("http://localhost:4200")
    public Collection<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public Site getSiteById(@PathVariable final Long id) {
        Optional<Site> site = siteRepository.findById(id);
        if(site.isPresent()) {
            return site.get();
        }
        else {
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin("http://localhost:4200")
    public Site create(@RequestBody Site site) {
        return siteRepository.save(site);
    }

    @PutMapping
    @CrossOrigin("http://localhost:4200")
    public Site update(@RequestBody Site site) {

        siteRepository.findById(site.getId()).orElseThrow(SiteNotFoundException::new);

        return siteRepository.save(site);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public void delete(@PathVariable final Long id) {

        siteRepository.findById(id).orElseThrow(SiteNotFoundException::new);

        siteRepository.deleteById(id);
    }

}
