package fr.suiviStagiaire.formation.autoEvaluation.technique;

import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Class qui permet de transformer une Date SQL en LocalDate et vice et versa,
 * Déclencher automatiquement a chaque insertion/récupération d'une date dans la base de données
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 19/07/2017
 *
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
	/**
	 * Converti d'une LocalDate vers Date SQL
	 */
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
    	return (locDate == null ? null : Date.valueOf(locDate));
    }

    /**
	 * Converti d'une  Date SQL vers LocalDate
	 */
    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
    	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
	
}