package org.datanucleus.samples.jdo.one_many_bidir;

import java.io.Serializable;
import java.util.StringTokenizer;

public class Card
{
    String suit = null;
    String number = null;
    Pack pack = null;

    public Card(String suit,String number)
    {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getNumber()
    {
        return number;
    }

    public Pack getPack()
    {
        return pack;
    }

    public void setPack(Pack pack)
    {
        this.pack = pack;
    }

    public String toString()
    {
        return "The " + number + " of " + suit;
    }

    // Primary Key
    public static class CardKey implements Serializable
    {
        public String suit;
        public String number;

        /**
         *  Default constructor (mandatory for JDO).
         **/
        public CardKey()
        {
        }

        /**
         * String constructor (mandatory for JDO).
         **/
        public CardKey(String str) 
        {
            StringTokenizer toke = new StringTokenizer (str, "::");
            str = toke.nextToken ();
            this.suit = str;
            str = toke.nextToken ();
            this.number = str;
        }

        /**
         * Implementation of equals method (JDO requirement).
         **/
        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof CardKey))
            {
                return false;
            }
            CardKey c=(CardKey)obj;

            return suit.equals(c.suit) && number.equals(c.number);
        }

        /**
         * Implementation of hashCode (JDO requirement)
         **/
        public int hashCode ()
        {
            return this.suit.hashCode() ^ this.number.hashCode();
        }

        /**
         * Implementation of toString that outputs this object id's PK values.
         * (JDO requirement).
         **/
        public String toString ()
        {
            return this.suit + "::" + this.number;
        }
    }
}
