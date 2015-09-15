package org.groovytutorial.shapes

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject

@Subject(Sides)
@Narrative("""Checks the Sides trait (via a Rectangle)
I want to make sure that the Sides fields are protected from externally meddling
""")
class InfoHiding extends Specification {

    def "The sides trait's map of sides shouldn't be externally mutable - Rectangle version"() {
        given: "A new Sides-based shape"
        Sides s = new Rectangle(5, 10)
        Exception exception //just to hold the expected exception

        when: "I attempt to modify an element"
        try {
            s.d = 100
        } catch (e) {
            exception = e
        }

        then: "it doesn't actually work so the sides and perimeter are correct but an exception was raised"
        30 == s.perimeter
        [ a: 5, b: 10, c: 5, d: 10 ] == s.sideMap
        ReadOnlyPropertyException == exception.class
    }

    def "The sides trait's map of sides shouldn't be externally mutable - Square version"() {
        given: "A new Sides-based shape"
        Sides s = new Square(5)
        Exception exception //just to hold the expected exception

        when: "I attempt to modify an element"
        try {
            s.d = 100
        } catch (e) {
            exception = e
        }

        then: "it doesn't actually work so the sides and perimeter are correct but an exception was raised"
        20 == s.perimeter
        [ a: 5, b: 5, c: 5, d: 5 ] == s.sideMap
        ReadOnlyPropertyException == exception.class
    }

    def "The sides trait's map of sides shouldn't be externally mutable - Triangle version"() {
        given: "A new Sides-based shape"
        Sides s = new Triangle(5, 5, 5)
        Exception exception //just to hold the expected exception

        when: "I attempt to modify an element"
        try {
            s.d = 100
        } catch (e) {
            exception = e
        }

        then: "it doesn't actually work so the sides and perimeter are correct but an exception was raised"
        15 == s.perimeter
        [ a: 5, b: 5, c: 5 ] == s.sideMap
        ReadOnlyPropertyException == exception.class
    }

    def "The sides trait's map of sides can't be reassigned"() {
        given: "A new Sides-based shape"
        Sides s = new Rectangle(5, 10)
        Exception exception //just to hold the expected exception

        when: "an attempt is made to assign the sideMap field to a new map"
        try {
            s.sideMap = [ : ]
        } catch (e) {
            exception = e
        }

        then: "the correct exception and s.sideMap hasn't changed"
        ReadOnlyPropertyException == exception.class
        [ a: 5, b: 10, c: 5, d: 10 ] == s.sideMap
    }

    def "The sides perimeter value can't be reassigned"() {
        given: "A new Sides-based shape"
        Sides s = new Rectangle(5, 10)
        Exception exception //just to hold the expected exception

        when: "an attempt is made to externally assign a value to the property field"
        try {
            s.perimeter = 1_000_000
        } catch (e) {
            exception = e
        }

        then: "the correct exception and the perimeter hasn't changed"
        ReadOnlyPropertyException == exception.class
        30 == s.perimeter
    }
}
