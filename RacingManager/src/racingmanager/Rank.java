/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;
import java.io.Serializable;
//import java.util.*;
/**
 *
 * @author axelferreira
 */
public class Rank implements Serializable 
{
    private static final long serialVersionUID = 1L;

    private Record first;
    private Record second;
    private Record third;

    public Rank() 
    { first = null;
      second = null;
      third = null;
    }

    public Rank(Record first, Record second, Record third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public Rank (Rank r)
    {   this.first = r.getFirst();
        this.second = r.getSecond();
        this.third = r.getThird();
    }

    public Record getFirst() 
    {   return first;  }

    public void setFirst(Record first) 
    {   this.first = first;  }

    public Record getSecond() 
    {   return second; }

    public void setSecond(Record second) 
    {   this.second = second; }

    public Record getThird() 
    {   return third; }

    public void setThird(Record third) 
    {   this.third = third; }
    
    
    
}
