function filterProgram(y){
	var x = y.title;
	var bodycl = document.getElementById("contentActivity");
	var list=bodycl.getElementsByTagName("h2");
	console.log(list.length);
	for(j=0;j<list.length;j++){
		list[j].parentNode.style.display="none";
	}
	for(i=0;i<list.length;i++){
		if(list[i].title==x){
			list[i].parentNode.style.display="block";
		}
	}
}