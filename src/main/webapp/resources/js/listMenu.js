/**
 * Created by kshahin on 6/18/2015.
 */

//var str;
// str = '[{"label":"africa","id":2,"children":[{"label":"opt","id":4,"children":[{"label":"sbor1","id":6,"children":[]},{"label":"sbor3","id":7,"children":[]}]},{"label":"roznica","id":5,"children":[{"label":"sbor2","id":8,"children":[]},{"label":"sbor3","id":9,"children":[]}]}]},{"label":"azia","id":3,"children":[{"label":"opt","id":10,"children":[{"label":"sbor5","id":12,"children":[]},{"label":"sbor7","id":13,"children":[]},{"label":"sbor2","id":14,"children":[]}]},{"label":"roznica","id":11,"children":[{"label":"sbor1","id":15,"children":[]}]}]}]';
// str = '{"label":"sbory","id":1,"children":[{"label":"africa","id":2,"children":[{"label":"opt","id":4,"children":[{"label":"sbor1","id":6,"children":[]},{"label":"sbor3","id":7,"children":[]}]},{"label":"roznica","id":5,"children":[{"label":"sbor2","id":8,"children":[]},{"label":"sbor3","id":9,"children":[]}]}]},{"label":"azia","id":3,"children":[{"label":"opt","id":10,"children":[{"label":"sbor5","id":12,"children":[]},{"label":"sbor7","id":13,"children":[]},{"label":"sbor2","id":14,"children":[]}]},{"label":"roznica","id":11,"children":[{"label":"sbor1","id":15,"children":[]}]}]}]}';

//$.ajax({url: "/Ebase/getMenu", success: function (result) {
// str = result;
//}});
function listMenu() {
    $.getJSON('/Ebase/getMenu', {}, function (obj) {
        //var obj = JSON.parse(str);


        var div = document.createElement("div");
        div.className = "list-group panel";


        var divParent = document.getElementById("JMenu");

        divParent.appendChild(div);
        if (obj instanceof Array) {
            for (j = 0; j < obj.length; j++) {
                myParse(obj[j], div, "JMenu");
            }
        } else myParse(obj, div, "JMenu");

        function myParse(obj, parrent, dataParent) {
            debugger;
            var href;
            var a = document.createElement("a");
            var label = document.createTextNode(obj.label);
            var id = document.createTextNode(obj.id);
            a.appendChild(label);
            a.setAttribute('class', 'list-group-item');
            if (obj.children.length != 0) {
                a.setAttribute('href', "#" + obj.id);
                a.setAttribute('data-toggle', "collapse");
                a.setAttribute('data-parent', dataParent);
                parrent.appendChild(a);
                var divIn = document.createElement("div");
                divIn.setAttribute('class', 'collapse');
                divIn.setAttribute('id', obj.id);
                parrent.appendChild(divIn);
                for (var i = 0; i < obj.children.length; i++) {
                    dataParent = obj.id;
                    myParse(obj.children[i], divIn, dataParent);
                }
            }
            else {
                a.setAttribute('href','/Ebase/page?id='+obj.id);
                parrent.appendChild(a);
            }
        }

    })
}
