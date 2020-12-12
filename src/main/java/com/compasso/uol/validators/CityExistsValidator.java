package com.compasso.uol.validators;

import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.CidadeService;
import com.compasso.uol.validators.annotations.CityMustExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityExistsValidator implements ConstraintValidator<CityMustExists, Long> {

    @Autowired
    private CidadeService cidadeService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Cidade cidade = cidadeService.findById(value);

        return cidade != null;
    }

}
