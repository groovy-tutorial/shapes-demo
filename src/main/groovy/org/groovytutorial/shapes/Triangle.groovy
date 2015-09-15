package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a generic triangle.
 *
 * For more specific types, use a class from {@link org.groovytutorial.shapes.triangle}
 */
@EqualsAndHashCode(includes = 'sideMap')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Triangle implements TwoDimensionalShape, Sides {
    static final String SHAPE_NAME = 'Triangle'

    Triangle(Number a, Number b, Number c) {
        this.a = a
        this.b = b
        this.c = c

        //Calling this causes the Sides trait to calculate the perimeter
        //and lock off its sideMap
        this.perimeter
    }

    /**
     * Uses Heron's formula to determine the area of the Triangle
     *
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     */
    static BigDecimal calculateArea(Number a, Number b, Number c) {
        Number s = (a + b + c) / 2
        Math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

    @Override
    BigDecimal getArea() {
        calculateArea(a, b, c)
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: Side A = $a; Side B = $b; \
Side C = $c; perimeter = $perimeter; area = $area"
    }
}
