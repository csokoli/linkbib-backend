package com.csokoli.linkbib.repository;

import com.csokoli.linkbib.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface SiteRepository extends JpaRepository<Site, Long> {
}
