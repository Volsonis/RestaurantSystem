package db.wrapper ;

import java.util.Map ;
import java.util.HashMap ;
import java.sql.Connection ;
import java.sql.SQLException ;
import com.javaranch.common.Str ;
import com.javaranch.db.DBResults ;
import com.javaranch.db.TableFacade ;

/** Strongly typed access to the database table "drinks".
 *
 * This source file was automatically generated by "Jenny the db code generator"
 * based on information found in the database.  Do not modify this file!
 *
 * For more information on Jenny, see http://www.javaranch.com/jenny.jsp
 *
 *
 * Most of the methods are static so you don't need to instantiate a copy of this class 
 * to do your work.  The primary access methods are:
 * <ul>
 *
 *     <b>getRow()/getRows()/getAllRows()</b><br>
 *     <b>search() </b><i>like getRows(), but you can specify which columns you want back</i><br>
 *     <b>update()</b><br>
 *     <b>delete()</b><br>
 *     <b>insert()</b><br>
 *
 * </ul>
 *
 * These methods all have the option of passing in a connection as the first parameter.
 * Usually you won't use a connection directly, but sometimes it's useful.
 *
 * The getRows() methods all return an array of Row objects or a single Row object.  The
 * row object is easy to work with and provides strong type checking.  If your table has
 * a lot of columns, and your search will return a lot of rows, you might want to consider
 * using a search() method instead.  You lose some of your strong type checking, but 
 * you might go a lot easier on memory.  In these cases, you will want to make sure you
 * use the column name constants found at the top of this class.
 *
 */
public class DrinksTable
{

    private static Implementation imp = new Implementation();

    public static final String tableName = "drinks";

    public static final String drinks_idColumnName = "drinks_id";
    public static final String nameColumnName = "name";
    public static final String priceColumnName = "price";

    private static String[] allColumns =
    {
        drinks_idColumnName , nameColumnName , priceColumnName , 
    };

    /** You probably want to use the static methods for most of your access, but once in a while you might need to
     *  pass an instance object to a method that knows how to work with these sorts of tables.
     */
    public static Implementation getInstance()
    {
        return imp ;
    }

    /** For use by unit testing, although you could provide your own implementation here if
     *  you wanted to.
     *  
     *  To use this in your unit testing, create an instance of MockDrinksTable and pass
     *  it in here.  Then set your mock return values, call the method you are testing and examine
     *  the mock values that are now set!
     */
    public static void setInstance( DrinksTable.Implementation instance  )
    {
        imp = instance ;
    }

    /** Exposed for unit testing purposes only! */
    static class Implementation extends TableFacade
    {

        /** Exposed for unit testing purposes only! */
        Implementation()
        {
            super( ProjectFacade.getInstance() , tableName );
        }

        // convert a DBResults object to an array of Row objects.
        // requires that all of the columns be represented in the DBResults object and in the right order
        private static Row[] rowArray( DBResults r )
        {
            Row[] rows = new Row[ r.size() ];
            for( int i = 0 ; i < rows.length ; i++ )
            {
                rows[ i ] = new Row( r.getRow( i ) );
            }
            return rows ;
        }

        /** Instantiate an empty Row object */
        public Row getRow()
        {
            // if you are wondering about why this method is so lame - it's for unit testing!
            // The idea is that during unit testing, a different test object will be returned here.
            // To learn more about unit testing with Jenny generated code, visit <a href="http://www.javaranch.com/jenny.jsp">www.javaranch.com/jenny.jsp</a>
            return new Row();
        }

        /** Instantiate a Row object and fill its content based on a search for the ID. 
         *
         * Return null if not found.  Return first item if more than one found.
         */
        public Row getRow( Connection con , int drinks_id ) throws SQLException
        {
            Row row = new Row( this.search( con , "drinks_id" , String.valueOf( drinks_id ) , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Instantiate a Row object and fill its content based on a search for the ID.
         *
         * Return null if not found.
         */
        public Row getRow( long drinks_id ) throws SQLException
        {
            Row row = new Row( this.search( "drinks_id" , String.valueOf( drinks_id ) , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Instantiate a Row object and fill its content based on a search
         *
         * Return null if not found.
         */
        public Row getRow( Connection con , String column , String searchText ) throws SQLException
        {
            Row row = new Row( this.search( con , column , searchText , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Instantiate a Row object and fill its content based on a search
         *
         * Return null if not found.
         */
        public Row getRow( String column , String searchText ) throws SQLException
        {
            Row row = new Row( this.search( column , searchText , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String column , String searchText ) throws SQLException
        {
            return rowArray( this.search( con , column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String column , String searchText ) throws SQLException
        {
            return rowArray( this.search( column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String column , String[] searchText ) throws SQLException
        {
            return rowArray( this.search( con , column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String column , String[] searchText ) throws SQLException
        {
            return rowArray( this.search( column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String whereClause ) throws SQLException
        {
            return rowArray( this.search( con , whereClause , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String whereClause ) throws SQLException
        {
            return rowArray( this.search( whereClause , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getAllRows( Connection con ) throws SQLException
        {
            return rowArray( this.search( con , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getAllRows() throws SQLException
        {
            return rowArray( this.search( allColumns ) );
        }

        public void update( Connection con , int drinks_id , Map data ) throws SQLException
        {
            this.update( con , "drinks_id" , String.valueOf( drinks_id ) , data );
        }

        public void update( int drinks_id , Map data ) throws SQLException
        {
            this.update( "drinks_id" , String.valueOf( drinks_id ) , data );
        }

        public void delete( Connection con , long drinks_id ) throws SQLException
        {
            this.delete( con , "drinks_id" , String.valueOf( drinks_id ) );
        }

        public void delete( long drinks_id ) throws SQLException
        {
            this.delete( "drinks_id" , String.valueOf( drinks_id ) );
        }

        public long insertAndGetID( Connection con , Map data ) throws SQLException
        {
            return this.insertAndGetID( con , data , "drinks_id" );
        }

        public long insertAndGetID( Map data ) throws SQLException
        {
            return this.insertAndGetID( data , "drinks_id" );
        }


    }

    public static class Row
    {

        private boolean dataLoadedFromDatabase = false ;

        private int drinks_id ;
        private String name ;
        private double price ;
        private boolean priceNull = true ;

        /** for internal use only!   If you need a row object, use getRow(). */
        Row()
        {
        }

        private Row( String[] data )
        {
            if ( data != null )
            {
                this.drinks_id =  Str.toInt( data[0] );
                this.name = data[1];
                this.priceNull = ( data[2] == null );
                this.price = priceNull ? 0.0 : Str.toDouble( data[2] );
                dataLoadedFromDatabase = true ;
            }
        }

        private Row( DBResults results )
        {
            this( results.getRow(0) );
        }

        public int getDrinks_id()
        {
            return drinks_id ;
        }

        public void setDrinks_id( int drinks_id )
        {
            this.drinks_id = drinks_id ;
        }


        public String getName()
        {
            return name ;
        }

        public void setName( String name )
        {
            this.name = name ;
        }


        public double getPrice()
        {
            return price ;
        }

        public void setPrice( double price )
        {
            this.price = price ;
            priceNull = false ;
        }

        public void setPrice( Double price )
        {
            priceNull = ( price == null );
            if ( priceNull )
            {
                this.price = 0.0 ;
            }
            else
            {
                this.price = price.doubleValue() ;
            }
        }

        public boolean isPriceNull()
        {
            return priceNull ;
        }

        public void setPriceNull( boolean priceNull )
        {
            this.priceNull = priceNull ;
            if ( priceNull )
            {
                price = 0.0 ;
            }
        }



        
        private boolean dataLoadedFromDatabase()
        {
            return dataLoadedFromDatabase ;
        }

        private Map buildDataMap()
        {
            Map data = new HashMap();
            data.put( drinks_idColumnName , String.valueOf(  this.drinks_id ) );
            data.put( nameColumnName , this.name );
            data.put( priceColumnName , this.priceNull ? null : String.valueOf( this.price ) );
            return data ;
        }

        /** update a row object based on a search */
        public void update( Connection con , String column , String searchText ) throws SQLException
        {
            imp.update( con , column , searchText , buildDataMap() );
        }

        /** update a row object based on a search */
        public void update( String column , String searchText ) throws SQLException
        {
            imp.update( column , searchText , buildDataMap() );
        }

        /** update a row object based on the id */
        public void update( Connection con ) throws SQLException
        {
            imp.update( con , drinks_id , buildDataMap() );
        }

        /** update a row object based on the id */
        public void update() throws SQLException
        {
            imp.update( drinks_id , buildDataMap() );
        }

        /** create a new row complete with a new ID.

            The current ID is ignored.  The new ID is placed in the row.

            @return the new row ID 
        */
        public long insert( Connection con ) throws SQLException
        {
            return imp.insertAndGetID( con , buildDataMap() );
        }

        /** create a new row complete with a new ID.

            The current ID is ignored.  The new ID is placed in the row.

            @return the new row ID 
        */
        public long insert() throws SQLException
        {
            return imp.insertAndGetID( buildDataMap() );
        }

        /** delete a row object based on the id */
        public void delete( Connection con ) throws SQLException
        {
            imp.delete( con , drinks_id );
        }

        /** delete a row object based on the id */
        public void delete() throws SQLException
        {
            imp.delete( drinks_id );
        }


    }

    /** Return an empty row object */
    public static Row getRow()
    {
        return imp.getRow();
    }

    /** Instantiate a Row object and fill its content based on a search for the ID. 
     *
     * Return null if not found.
     */
    public static Row getRow( Connection con , int drinks_id ) throws SQLException
    {
        return imp.getRow( con , drinks_id );
    }

    /** Instantiate a Row object and fill its content based on a search for the ID. 
     *
     * Return null if not found.
     */
    public static Row getRow( long drinks_id ) throws SQLException
    {
        return imp.getRow( drinks_id );
    }

    /** Instantiate a Row object and fill its content based on a search
     *
     * Return null if not found.
     */
    public static Row getRow( Connection con , String column , String searchText ) throws SQLException
    {
        return imp.getRow( con , column , searchText );
    }

    /** Instantiate a Row object and fill its content based on a search
     *
     * Return null if not found.
     */
    public static Row getRow( String column , String searchText ) throws SQLException
    {
        return imp.getRow( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , String searchText ) throws SQLException
    {
        return imp.getRows( con , column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , String searchText ) throws SQLException
    {
        return imp.getRows( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , String[] searchText ) throws SQLException
    {
        return imp.getRows( con , column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , String[] searchText ) throws SQLException
    {
        return imp.getRows( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , int searchValue ) throws SQLException
    {
        return imp.getRows( con , column , String.valueOf( searchValue ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , int searchValue ) throws SQLException
    {
        return imp.getRows( column , String.valueOf( searchValue ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , int[] searchValues ) throws SQLException
    {
        return imp.getRows( con , column , Str.toStringArray( searchValues ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , int[] searchValues ) throws SQLException
    {
        return imp.getRows( column , Str.toStringArray( searchValues ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String whereClause ) throws SQLException
    {
        return imp.getRows( con , whereClause );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String whereClause ) throws SQLException
    {
        return imp.getRows( whereClause );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getAllRows( Connection con ) throws SQLException
    {
        return imp.getAllRows( con );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getAllRows() throws SQLException
    {
        return imp.getAllRows();
    }

    public static DBResults search( Connection con , String column , String searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchText , dataColumns );
    }

    public static DBResults search( String column , String searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchText , dataColumns );
    }

    public static DBResults search( Connection con , String column , String[] searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchText , dataColumns );
    }

    public static DBResults search( String column , String searchText[] , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchText , dataColumns );
    }

    public static DBResults search( Connection con , String column , int searchValue , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchValue , dataColumns );
    }

    public static DBResults search( String column , int searchValue , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchValue , dataColumns );
    }

    public static DBResults search( Connection con , String column , int[] searchValues , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchValues , dataColumns );
    }

    public static DBResults search( String column , int[] searchValues , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchValues , dataColumns );
    }

    public static DBResults search( Connection con , String whereClause , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , whereClause , dataColumns );
    }

    public static DBResults search( String whereClause , String[] dataColumns ) throws SQLException
    {
        return imp.search( whereClause , dataColumns );
    }

    public static DBResults search( Connection con , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , dataColumns );
    }

    public static DBResults search( String[] dataColumns ) throws SQLException
    {
        return imp.search( dataColumns );
    }

    public static void update( Connection con , String column , String searchText , Map data ) throws SQLException
    {
        imp.update( con , column , searchText , data );
    }

    public static void update( String column , String searchText , Map data ) throws SQLException
    {
        imp.update( column , searchText , data );
    }

    public static void delete( Connection con , long drinks_id ) throws SQLException
    {
        imp.delete( con , drinks_id );
    }

    public static void delete( long drinks_id ) throws SQLException
    {
        imp.delete( drinks_id );
    }

    public static void delete( Connection con , String column , String searchText ) throws SQLException
    {
        imp.delete( con , column , searchText );
    }

    public static void delete( String column , String searchText ) throws SQLException
    {
        imp.delete( column , searchText );
    }

    public static long insert( Connection con , Map data ) throws SQLException
    {
        return imp.insertAndGetID( con , data );
    }

    public static long insert( Map data ) throws SQLException
    {
        return imp.insertAndGetID( data );
    }



}
