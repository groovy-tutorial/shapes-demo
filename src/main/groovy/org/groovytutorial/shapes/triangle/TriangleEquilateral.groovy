package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * A triangle with three equal sideMap
 *
 * @see <a href="https://en.wikipedia.org/wiki/Equilateral_triangle">Wikipedia - Equilateral triangle</a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleEquilateral extends TriangleIsosceles {
    static final String TRIANGLE_TYPE = 'Equilateral'

    TriangleEquilateral(Number a) {
        super(a, a)
    }

    static BigDecimal calculateArea(Number a) {
        Math.sqrt(3) / 4 * a**2
    }

    @Override
    BigDecimal getArea() {
        calculateArea(a)
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.displayInfo}"
    }
}

