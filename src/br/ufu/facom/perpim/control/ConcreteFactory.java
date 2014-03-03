/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.perpim.control;

import br.ufu.facom.frameworkpim.control.AbstractFactory;
import br.ufu.facom.frameworkpim.control.EventoControl;
import br.ufu.facom.frameworkpim.control.StickyNotesControl;

/**
 *
 * @author Hugo
 */
public class ConcreteFactory implements AbstractFactory {

    @Override
    public EventoControl createEventoControl() {
        return new EventoControlImpl();

    }

    @Override
    public StickyNotesControl createCtickyNotesControl() {
        return new StickyNotesControlImpl();
    }

}
