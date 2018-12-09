/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author mmohamud
 */
public class QueryBuilder {
    Matcher matcher;
    Matcher [] matchers;

    public QueryBuilder() {
        matcher = new And(new All());
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public Matcher build() {
        return matcher;
    }

    public QueryBuilder playsIn (String team){
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast (int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan (int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
}
