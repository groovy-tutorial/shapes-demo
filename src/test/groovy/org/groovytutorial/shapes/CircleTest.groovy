package org.groovytutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Circle)
class CircleTest extends Specification {

    def "Circle.calculateDiameter returns #result for a radius of #radius"() {
        expect:
        result == Circle.calculateDiameter(radius)

        where:
        radius || result
        2 || 4
        10 || 20
        6 || 12
    }

    def "Circle.calculatePerimeter returns #result for a radius of #radius"() {
        expect:
        result.round(MC) == Circle.calculatePerimeter(radius).round(MC)

        where:
        radius || result
        2 || 12.56637g
        10 || 62.83185g
        6 || 37.69911g
    }

    def "Circle.calculateArea returns #result for a radius of #radius"() {
        expect:
        result.round(MC) == Circle.calculateArea(radius).round(MC)

        where:
        radius || result
        2 || 12.56637g
        10 || 314.1593g
        6 || 113.0973g
    }

    def "Ensure that equality check is correctly returning #result when a new Circle(#radius) is compared to #rhs"() {
        given: "A new Circle"
        Circle r = new Circle(radius)

        expect:
        result == (r == rhs)

        where:
        radius | rhs            || result
        2      | new Circle(2)  || true
        5      | new Circle(4)  || false
        10     | new Expando(radius: 10) || false
    }

    def "Circle of radius #radius has a diameter of #diameter, a perimeter of #perimeter and an area of #area"() {
        given: "A new Circle"
        Circle r = new Circle(radius)

        expect: "that the fields are set correctly"
        r.radius == radius
        r.diameter == radius * 2
        r.perimeter.round(MC) == perimeter.round(MC)
        r.perimeter.round(MC) == r.circumference.round(MC)
        r.area.round(MC) == area.round(MC)

        where: "the dimensions and resulting measurements are"
        radius || diameter | perimeter | area
        2 || 4 | 12.56637g | 12.56637g
        10 || 20 | 62.83185g | 314.1593g
        6 || 12 | 37.69911g | 113.0973g
    }
}
