package com.battelship.suitecases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.battelship.test.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   GameTest.class,
   JugadorTest.class,
   ManagerIOTest.class,
   MenuTest.class,
   PartidaTest.class,
   PosicionTest.class,
   TableroTest.class
})

public class SuiteTestRunner {   
}  