package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.groovytutorial.shapes.Triangle

/**
 * A triangle with two sideMap of equal length
 *
 * @see <a href="https://en.wikipedia.org/wiki/Isosceles_triangle">Wikipedia - Isosceles triangle</a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
class TriangleIsosceles extends Triangle {
    static final String TRIANGLE_TYPE = 'Isosceles'

    TriangleIsosceles(Number a, Number b) {
        super(a, b, b)
    }

    static BigDecimal calculateArea(Number a, Number b) {
        def height = Math.sqrt(b**2 - (a**2 / 4))
        a * (height / 2)
    }

    @Override
    BigDecimal getArea() {
        calculateArea(a, b)
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.displayInfo}"
    }
}
