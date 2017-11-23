package com.nsa.clinical.repositories;

import com.nsa.clinical.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by James on 20/11/2017.
 */
    public interface OptionRepository extends JpaRepository<Option,Long> {

}
