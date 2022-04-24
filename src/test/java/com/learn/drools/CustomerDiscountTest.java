package com.learn.drools;

import com.learn.drools.config.DroolsBeanFactory;
import com.learn.drools.model.Customer;
import com.learn.drools.model.CustomerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDiscountTest {

    private KieSession kSession;

    DroolsBeanFactory droolsBeanFactory = new DroolsBeanFactory();

    @BeforeEach
    public void setup() {
        kSession = droolsBeanFactory.getKieSession("Discount.xls");
    }

    @Test
    void kiSessionIsLoaded() {
        Assertions.assertNotNull(kSession);
    }

    @Test
    public void
    giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount()
            throws Exception {
        Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
        kSession.insert(customer);

        kSession.fireAllRules();

        assertEquals(customer.getDiscount(), 15);
    }

    @Test
    public void giveIndvidualRecent_whenFireRule_thenCorrectDiscount()
            throws Exception {
        Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);
        kSession.insert(customer);

        kSession.fireAllRules();

        assertEquals(customer.getDiscount(), 5);
    }

    @Test
    public void
    giveBusinessAny_whenFireRule_thenCorrectDiscount()
            throws Exception {
        Customer customer = new Customer(CustomerType.BUSINESS, 0);
        kSession.insert(customer);

        kSession.fireAllRules();

        assertEquals(customer.getDiscount(), 20);
    }

    @Test
    void getDrlFile() {
        System.out.println(droolsBeanFactory.getDrlFromExcel("Discount.xls"));
    }
}
