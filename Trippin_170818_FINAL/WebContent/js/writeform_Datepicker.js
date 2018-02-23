$(function() {
	   var dateFormat = "mm/dd/yy",
	      from = $("#from").datepicker({defaultDate: "+1w",numberOfMonths: 1})
	        .on( "change", function() {
	          to.datepicker( "option", "minDate", getDate( this ) );
	        }),
	      to = $( "#to" ).datepicker({
	        defaultDate: "+1w",
	        numberOfMonths: 1
	      })
	      .on( "change", function() {
	        from.datepicker( "option", "maxDate", getDate( this ) );
	      });
	 
	    function getDate( element ) {
	      var date;
	      try {
	        date = $.datepicker.parseDate( dateFormat, element.value );
	      } catch( error ) {
	        date = null;
	      }
	 
	      return date;
	    }
	    
	    $("#datepicker1").click(function() {
	    	$("#from").datepicker("show");
	    	
	    });
	    $("#datepicker2").click(function() {
	    	$("#to").datepicker("show");
	    })
	  } );
