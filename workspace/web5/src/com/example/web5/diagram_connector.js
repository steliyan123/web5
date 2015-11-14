window.com_example_web5_Diagram = function() {
    var diagramElement = this.getElement();
    var treeData = [
                    {
                      "name": "Top Level",
                      "parent": "null",
                      "value": 10,
                      "type": "black",
                      "level": "red",
                      "icon": "document.png",
                      "children": [
                        {
                          "name": "Level 2: A",
                          "parent": "Top Level",
                          "value": 5,
                          "type": "grey",
                          "level": "red",
                         "icon": "genius.png",
                          "children": [
                            {
                              "name": "Son of A",
                              "parent": "Level 2: A",
                              "value": 5,
                              "type": "steelblue",
                              "icon": "profle.png",
                              "level": "orange"
                            },
                            {
                              "name": "Daughter of A",
                              "parent": "Level 2: A",
                              "value": 18,
                              "type": "steelblue",
                              "icon": "vlc.png",
                              "level": "red"
                            }
                          ]
                        },
                        {
                          "name": "Level 2: B",
                          "parent": "Top Level",
                          "value": 10,
                          "type": "grey",
                          "icon": "profle.png",
                          "level": "green"
                        }
                      ]
                    }
                  ];

                  // ************** Generate the tree diagram	 *****************
                  var margin = {top: 20, right: 120, bottom: 20, left: 120},
                  	width = 960 - margin.right - margin.left,
                  	height = 500 - margin.top - margin.bottom;
                  	
                  var i = 0;

                  var tree = d3.layout.tree()
                  	.size([height, width]);

                  var diagonal = d3.svg.diagonal()
                  	.projection(function(d) { return [d.y, d.x]; });

                  var svg = d3.select(".v-verticallayout").append("svg")
                  	.attr("width", width + margin.right + margin.left)
                  	.attr("height", height + margin.top + margin.bottom)
                    .append("g")
                  	.attr("transform", 
                  	      "translate(" + margin.left + "," + margin.top + ")");

                  root = treeData[0];
                    
                  update(root);

                  function update(source) {

                    // Compute the new tree layout.
                    var nodes = tree.nodes(root).reverse(),
                  	  links = tree.links(nodes);

                    // Normalize for fixed-depth.
                    nodes.forEach(function(d) { d.y = d.depth * 180; });

                    // Declare the nodes…
                    var node = svg.selectAll("g.node")
                  	  .data(nodes, function(d) { return d.id || (d.id = ++i); });

                    // Enter the nodes.
                    var nodeEnter = node.enter().append("g")
                  	  .attr("class", "node")
                  	  .attr("transform", function(d) { 
                  		  return "translate(" + d.y + "," + d.x + ")"; });

                    nodeEnter.append("image")
                        .attr("xlink:href", function(d) { return d.icon; })
                        .attr("x", "-12px")
                        .attr("y", "-12px")
                        .attr("width", "24px")
                        .attr("height", "24px");

                    nodeEnter.append("text")
                  	  .attr("x", function(d) { 
                  		  return d.children || d._children ? 
                  		  (15) * -1 : + 15 })
                  	  .attr("dy", ".35em")
                  	  .attr("text-anchor", function(d) { 
                  		  return d.children || d._children ? "end" : "start"; })
                  	  .text(function(d) { return d.name; })
                  	  .style("fill-opacity", 1);

                    // Declare the links…
                    var link = svg.selectAll("path.link")
                  	  .data(links, function(d) { return d.target.id; });

                    // Enter the links.
                    link.enter().insert("path", "g")
                  	  .attr("class", "link")
                  	  .style("stroke", function(d) { return d.target.level; })
                  	  .style("fill", "none")
                  	  .attr("d", diagonal);

                  }

    this.onStateChange = function() {
    	alert("it works blahfgfghfgh");
        var coords = this.getState().coords;
        //d3.selectAll("circle").transition().attr("cx", parseInt(coords[0]));
        //d3.selectAll("circle").transition().delay(500).attr("cy", parseInt(coords[1]));
    }
}