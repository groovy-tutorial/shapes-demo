package org.groovytutorial.shapes

/**
 * A basic trait describing the outer edges (sideMap) of a 2D shape
 *
 * @author Duncan Dickinson
 */
trait Sides {
    static final SIDE_NAME_PATTERN = /[a-z]/

    private final Map sideMap = [ : ]
    private BigDecimal perimeter = null

    /**
     * Calculates the perimeter of the shape (once)
     * @return the sum of the sideMap (the perimeter)
     */
    BigDecimal getPerimeter() {
        calculatePerimeter()
    }

    private BigDecimal calculatePerimeter() {
        if (!perimeter) {
            perimeter = sideMap.values().sum().toBigDecimal()
        }
        perimeter
    }

    /**
     * @return a CLONE of the sideMap
     */
    public Map getSideMap() {
        sideMap.clone() as Map
    }

    def propertyMissing(String name) {
        if (name.matches(SIDE_NAME_PATTERN)) {
            return sideMap.get(name)
        }

        throw new MissingPropertyException("Property $name not found")
    }

    def propertyMissing(String name, value) {
        if (name.matches(SIDE_NAME_PATTERN)) {
            if (perimeter) {
                throw new ReadOnlyPropertyException(name, Sides)
            } else {
                sideMap.put(name, value as Number)
                return sideMap.get(name)
            }
        }

        throw new MissingPropertyException("Property $name not found")
    }
}
