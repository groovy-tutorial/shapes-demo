package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'length,width')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Rectangle implements TwoDimensionalShape, Sides {

    static final String SHAPE_NAME = 'Rectangle'

    final BigDecimal area

    Rectangle(Number length, Number width) {
        a = length
        b = width
        c = length
        d = width

        //Calling this causes the Sides trait to calculate the perimeter
        //and lock off its sideMap
        this.perimeter

        this.area = length * width
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: length = $a; width = $b; perimeter = $perimeter; area = $area"
    }

}
