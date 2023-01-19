/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ControlData;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Estefania
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter <LocalDate, Date>{
    
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate)
          .map(Date::valueOf)
          .orElse(null);
    }

	// converts sql date to LocalDate using toLocalDate() method
    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
          .map(Date::toLocalDate)
          .orElse(null);
    }
    
//@Override
//public Date convertToDatabaseColumn(LocalDate attribute) {
//return attribute == null? null : Date.valueOf(attribute);
//}
//
//@Override
//  public LocalDate convertToEntityAttribute(Date date) {
//    
//    if(date!=null) {
//      LocalDate ld =date.toLocalDate();     
//      return ld;
//    }
//      
//    return null;
//  }
    
}
