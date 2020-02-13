package me.wonsey.ood.device;

import me.wonsey.ood.states.*;

public class Dog
{
   State barking;
   State eating;
   State playing;
   State running;
   State sleeping;
   State sitting;
   
   State state;
   String name;
   
   public Dog(String name)
   {
      this.barking = new BarkingState(this);
      this.eating = new EatingState(this);
      this.playing = new PlayingState(this);
      this.running = new RunningState(this);
      this.sleeping = new SleepingState(this);
      this.sitting = new SittingState(this);
      
      this.state = this.playing;
      this.name = name;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public State getState()
   {
      return this.state;
   }
   
   public void setState(State state)
   {
      this.state = state;
   }
   
   public State getBarking()
   {
      return this.barking;
   }

   public void setBarking(State barking)
   {
      this.barking = barking;
   }

   public State getEating()
   {
      return this.eating;
   }

   public void setEating(State eating)
   {
      this.eating = eating;
   }

   public State getPlaying()
   {
      return this.playing;
   }

   public void setPlaying(State playing)
   {
      this.playing = playing;
   }

   public State getRunning()
   {
      return this.running;
   }

   public void setRunning(State running)
   {
      this.running = running;
   }

   public State getSleeping()
   {
      return this.sleeping;
   }

   public void setSleeping(State sleeping)
   {
      this.sleeping = sleeping;
   }

   public State getSitting()
   {
      return this.sitting;
   }

   public void setSitting(State sitting)
   {
      this.sitting = sitting;
   }

   public void giveTreat()
   {
      this.state.giveTreat();
   }
   
   public void callOver()
   {
      this.state.callOver();
   }
   
   public void callLoudly()
   {
      this.state.callLoudly();
   }
   
   
}
