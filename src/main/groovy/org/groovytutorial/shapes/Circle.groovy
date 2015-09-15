package org.groovytutorial.shapes

import static java.lang.Math.PI

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a circle
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includes = 'radius')
@ToString(includeNames = true, includeFields = true, includePackage = true)
final class Circle implements TwoDimensionalShape {
    static final String SHAPE_NAME = 'Circle'

    final BigDecimal radius
    final BigDecimal perimeter
    final BigDecimal area

    /**
     *
     * @param radius the radius of the circle
     */
    Circle(BigDecimal radius) {
        this.radius = radius
        this.perimeter = calculatePerimeter(radius)
        this.area = calculateArea(radius)
    }

    static BigDecimal calculateCircumference(Number radius) {
        calculatePerimeter(radius)
    }

    static BigDecimal calculatePerimeter(Number radius) {
        (2 * PI * radius) as BigDecimal
    }

    static BigDecimal calculateArea(Number radius) {
        (PI * radius**2) as BigDecimal
    }

    static BigDecimal calculateDiameter(Number radius) {
        (radius * 2) as BigDecimal
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: radius = $radius; diameter = $diameter; \
circumference = ${circumference.trunc(4)}; area = ${area.trunc(4)}"
    }

    /**
     * Just a convenience - equivalent to getPerimeter
     * @return the circumference
     */
    BigDecimal getCircumference() {
        perimeter
    }

    /**
     * A pseudo getter
     * @return the diameter
     */
    Number getDiameter() {
        calculateDiameter(this.radius)
    }
}
