package com.sample;

//import org.jbpm.test.JbpmJUnitBaseTestCase;
import java.util.Date;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.rule.EntryPoint;

import redhat.brms6workshop.labs.Quote;
import redhat.brms6workshop.labs.QuoteEvent;

/**
 * This is a sample file to test a process.
 */
public class ProcessTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        
        KieSession kSession = kContainer.newKieSession();
        EntryPoint entrypoint = kSession.getEntryPoint("QuoteEventStream");
        
        
        QuoteEvent quoteEvent = new QuoteEvent();
        quoteEvent.setQuoteDate(new Date("2014-04-10"));
        
        entrypoint.insert(quoteEvent);
        
        kSession.fireAllRules();
	}

}