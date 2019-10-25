import React, { useState, useEffect } from 'react';


function Dropdown(props){
	
	let [regions, setRegions] = useState([]);
	let [provinces, setProvinces] = useState([]);	
	let [cities, setCities] = useState([]);
	let [barangays, setBarangays] = useState([]);

	let [regionId, setRegionId] = useState("");
	let [provinceId, setProvinceId] = useState("");	
	let [cityId, setCityId] = useState("");
	let [barangayId, setBarangayId] = useState("");


	    
	useEffect( ()=> {
        fetch("http://localhost:8080/regions")
        .then( (res)=> res.json() )
        .then( (data)=> {
        	
        	setRegions(data)  
        })
    }, []);

    let regionDisplay = regions.map(function(item){
        return (
			<option key={item.id} 
					value={item.id}>{item.regDesc}
			</option>
        )
    })
	
	let provinceDisplay = provinces.map(function(item){
    	return (
	       	<option key={item.id} 
	        		value={item.id}>{item.provDesc}
	       	</option>
	    )
    })
	
    let cityDisplay = cities.map(function(item){
        return (
        	<option key={item.id} 
        			value={item.id}>{item.citymunDesc}
        	</option>
        )
    })

    let barangayDisplay = barangays.map( function(item){
		return(
			<option key={item.id} 
					value={item.id}>{item.brgyDesc}
			</option>
		)
	})
	

    function regionChangeHandler(e){

    	
    	let value = e.target.value
    	console.log(value);
    	if (value.length == 1) {
			value = "0"+value;
		}


    	fetch("http://localhost:8080/provinces/region/"+value)
	          .then( (res)=> res.json())
	          .then( (data)=> setProvinces(data) ) 
  			
   		 	setRegionId(value);

    }
        	
    
    function provinceChangeHandler(e){

    	
    	let value = ('000' + e.target.value).slice(-4);
    	
    	
	        fetch("http://localhost:8080/cities/province/"+value)
	            .then( (res)=> res.json() )
	            .then( (data)=> setCities(data) ) 
	   
    	 
   			setProvinceId(value);
	}


    function cityChangeHandler(e){

    	let value = e.target.value*1

	    	
    	fetch("http://localhost:8080/barangays/city/"+value)
	      .then( (res)=> res.json() )
	      .then( (data)=> setBarangays(data) ) 

   		setCityId(value);
   	}

   	function barangayChangeHandler(e){
   		let value = e.target.value;
   		setBarangayId(value);
   	}
 	   

  
	
	return(
		<React.Fragment>
			<div className="bg-transparent d-flex justify-content-center w-100 p-3">
					<div className="bg-transparent form-group w-100">
						Region
						<select className="form-control" 
								onChange={regionChangeHandler}>
							<option></option>
							{regionDisplay}
						</select>
					</div>

					<div className="bg-transparent form-group w-100">
						Province
						<select className="form-control" 
								onChange={provinceChangeHandler}>
							<option></option>
							{provinceDisplay}
						</select>
					</div>
					<div className="bg-transparent form-group w-100">
						City
						<select className="form-control" 
								onChange={cityChangeHandler}>
							<option></option>
							{cityDisplay}
						</select>
					</div>
					<div className="bg-transparent form-group w-100">
						Barangay
						<select className="form-control" 
								onChange={barangayChangeHandler}>
							<option></option>
							{barangayDisplay}
						</select>
					</div>
					
			
			</div>
		</React.Fragment>

	
	)
   	
}


export default Dropdown;