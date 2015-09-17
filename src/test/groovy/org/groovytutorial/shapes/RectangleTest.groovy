package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Rectangle)
class RectangleTest extends Specification {
    def "Test that a rectangle of length #length and width #width has a perimeter of #perimeter and an area of #area"() {
        given: "A new rectangle"
        Rectangle r = new Rectangle(length, width)

        expect: "that the fields are set correctly"
        r.a == length
        r.b == width
        r.c == length
        r.d == width

        r.perimeter == perimeter
        r.area == area

        where: "the dimensions and resulting measurements are"
        length  | width || perimeter | area
        2       | 2     || 8         | 4
        10      | 7     || 34        | 70
        6       | 100   || 212       | 600
    }

    def "Ensure that a rectangle can only be defined with a positive numeric length and width"() {
        setup:
        Exception exception //just to hold the expected exception

        when: "A rectangle is set up with a bad length and/or width"
        try {
            Rectangle r = new Rectangle(length, width)
        } catch (e) {
            exception = e
        }

        then: "Expect one of two exceptions"
        exception?.class in [IllegalArgumentException, GroovyRuntimeException]

        where: "the dimensions and resulting measurements are"
        length   | width
        -2       | 2
        10       | -7
        -6       | -100
        'rabbit' | 1
        1        | false
        UUID.randomUUID() | 'apple'
    }
}
