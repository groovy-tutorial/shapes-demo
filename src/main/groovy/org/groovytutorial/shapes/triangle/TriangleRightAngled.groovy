package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.groovytutorial.shapes.Triangle

@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleRightAngled extends Triangle {
    static final String TRIANGLE_TYPE = 'Right-angled'

    TriangleRightAngled(Number a, Number b,
                        Number c = calculateHypotenuse(a, b)) {
        super(a, b, c)
    }

    static final Number calculateHypotenuse(Number a, Number b) {
        Math.sqrt(a**2 + b**2)
    }

    static calculateArea(Number a, Number b) {
        0.5 * a * b
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
