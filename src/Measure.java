/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a09.team.assignment;

/**
 *
 * @author deliapathak
 */
public enum Measure 
{
    CUP, TABLESPOON, TEASPOON, LB, UNIT;

    int cup;
    int tablespoon;
    int teaspoon;
    int lb;
    int unit;

    Measure(int unt)
    {
        unit = unt;
    }
    
    Measure (int cp, int tblsp, int tspn)
    {
        
    }

    
    


}
