package org.groovytutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC
import org.groovytutorial.shapes.triangle.TriangleEquilateral
import org.groovytutorial.shapes.triangle.TriangleIsosceles
import spock.lang.Specification

/**
 *
 *
 * @author Duncan Dickinson
 */
class TriangleAreaTest extends Specification {
    def "test calculateArea"() {
        expect:
        a == b
        b == c

        Triangle.calculateArea(a, b, c).round(MC) == TriangleIsosceles.calculateArea(a, b).round(MC)
        TriangleIsosceles.calculateArea(a, b).round(MC) == TriangleEquilateral.calculateArea(a).round(MC)

        area.round(MC) == Triangle.calculateArea(a, b, c).round(MC)

        where: "the dimensions and resulting measurements are"
        a | b | c || area
        3 | 3 | 3 || 3.89711431702998
    }
}
