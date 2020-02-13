package me.wonsey.ood.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import me.wonsey.ood.device.Dog;
import me.wonsey.ood.states.BarkingState;
import me.wonsey.ood.states.EatingState;
import me.wonsey.ood.states.PlayingState;
import me.wonsey.ood.states.RunningState;
import me.wonsey.ood.states.SittingState;
import me.wonsey.ood.states.SleepingState;

public class Tests
{
   
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;
   private final PrintStream originalErr = System.err;
   private final String dogName = "Milo";
   
   @Before
   public void setUp() throws Exception
   {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
   }
   
   @After
   public void tearDown() throws Exception
   {
      System.setOut(new PrintStream(originalOut));
      System.setErr(new PrintStream(originalErr));
   }
   
   private String getSyso()
   {
      String retval = "";
      try
      {
         retval = outContent.toString();
         outContent.reset();
      }
      catch (Exception e)
      {
         System.err.println("Well then");
      }
      return retval;
   }

   @Test
   public void testDog()
   {
      Dog milo = new Dog(dogName);
      assertTrue(milo.getState() instanceof PlayingState);
   }
   
   @Test
   public void testBarkingState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getBarking());
      assertTrue(milo.getState() instanceof BarkingState);
      
      milo.giveTreat();
      assertEquals(dogName+" quiets down to eat the treat\r\n", getSyso());
      assertTrue(milo.getState() instanceof EatingState);
      milo.setState(milo.getBarking());
      assertTrue(milo.getState() instanceof BarkingState);
      
      milo.callOver();
      assertEquals(dogName+" stops barking and runs over\r\n", getSyso());
      assertTrue(milo.getState() instanceof RunningState);
      milo.setState(milo.getBarking());
      assertTrue(milo.getState() instanceof BarkingState);
      
      milo.callLoudly();
      assertEquals(dogName+" thinks you are barking so continues\r\n", getSyso());
      assertTrue(milo.getState() instanceof BarkingState);
   }
   
   @Test
   public void testEatingState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getEating());
      assertTrue(milo.getState() instanceof EatingState);
      
      milo.giveTreat();
      assertEquals(dogName+" keeps eating\r\n", getSyso());
      assertTrue(milo.getState() instanceof EatingState);
      
      milo.callOver();
      assertEquals(dogName+" ignores you\r\n", getSyso());
      assertTrue(milo.getState() instanceof EatingState);
      
      milo.callLoudly();
      assertEquals(dogName+" barks at you\r\n", getSyso());
      assertTrue(milo.getState() instanceof BarkingState);
      milo.setState(milo.getEating());
      assertTrue(milo.getState() instanceof EatingState);
   }
   
   @Test
   public void testPlayingState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getPlaying());
      assertTrue(milo.getState() instanceof PlayingState);
      
      milo.giveTreat();
      assertEquals(dogName+" stops playing and starts eating the treat\r\n", getSyso());
      assertTrue(milo.getState() instanceof EatingState);
      milo.setState(milo.getPlaying());
      assertTrue(milo.getState() instanceof PlayingState);
      
      milo.callOver();
      assertEquals(dogName+" runs over\r\n", getSyso());
      assertTrue(milo.getState() instanceof RunningState);
      milo.setState(milo.getPlaying());
      assertTrue(milo.getState() instanceof PlayingState);
      
      milo.callLoudly();
      assertEquals(dogName+" sits in defiance!\r\n", getSyso());
      assertTrue(milo.getState() instanceof SittingState);
      milo.setState(milo.getPlaying());
      assertTrue(milo.getState() instanceof PlayingState);
   }
   
   @Test
   public void testRunningState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getRunning());
      assertTrue(milo.getState() instanceof RunningState);
      
      milo.giveTreat();
      assertEquals(dogName+" is too distracted to notice the treat\r\n", getSyso());
      assertTrue(milo.getState() instanceof RunningState);
      
      milo.callOver();
      assertEquals(dogName+" doesn't notice you calling it\r\n", getSyso());
      assertTrue(milo.getState() instanceof RunningState);
      
      milo.callLoudly();
      assertEquals(dogName+" notices you and stops and sits\r\n", getSyso());
      assertTrue(milo.getState() instanceof SittingState);
   }
   
   @Test
   public void testSittingState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getSitting());
      assertTrue(milo.getState() instanceof SittingState);
      
      milo.giveTreat();
      assertEquals(dogName+" was so excited it started playing\r\n", getSyso());
      assertTrue(milo.getState() instanceof PlayingState);
      milo.setState(milo.getSitting());
      assertTrue(milo.getState() instanceof SittingState);
      
      milo.callOver();
      assertEquals(dogName+" ignored you and lays down\r\n", getSyso());
      assertTrue(milo.getState() instanceof SleepingState);
      milo.setState(milo.getSitting());
      assertTrue(milo.getState() instanceof SittingState);
      
      milo.callLoudly();
      assertEquals(dogName+" starts to run over\r\n", getSyso());
      assertTrue(milo.getState() instanceof RunningState);
      milo.setState(milo.getSitting());
      assertTrue(milo.getState() instanceof SittingState);
   }

   @Test
   public void testSleepingState()
   {
      Dog milo = new Dog(dogName);
      
      milo.setState(milo.getSleeping());
      assertTrue(milo.getState() instanceof SleepingState);
      
      milo.giveTreat();
      assertEquals(dogName+" is asleep\r\n", getSyso());
      
      milo.callOver();
      assertEquals(dogName+" is asleep and didn't hear you\r\n", getSyso());
      
      milo.callLoudly();
      assertEquals(dogName+" woke up!\r\n", getSyso());
      assertTrue(milo.getState() instanceof SittingState);
   }

}
