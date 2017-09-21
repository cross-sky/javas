/**
 * Created by Crossing on 2017-9-21.
 */

$(document).ready(function(){
    var d_make = [[5, 3.2],[10, 3.7],[15, 3.4],[20, 2.7],[25, 2.4],[30, 2.6]],
        d_cost = [[5, 12.5],[10, 15.5],[15, 14.1],[20, 13.2],[25, 15.9],[30, 13.9]];

    var plot = $.plot($("#day_sincos"), [
        {data: d_make, label: "每日发电量"},
        {data: d_cost, label: "每日耗电量"}
        ], {
        series: {
            lines: { show: true,
                lineWidth: 2
            },
            points: { show: true },
            shadowSize: 2
        },
        grid: { hoverable: true,
            clickable: true,
            tickColor: "#dddddd",
            borderWidth: 0
        },
        colors: ["#FA5833", "#2FABE9"]
        /*
         xaxis: {
         axisLabel: 'Day',
         axisLabelUseCanvas: true,
         axisLabelFontSizePixels: 12,
         axisLabelFontFamily: 'Arial'
         },
         yaxis: [{
         axisLabel:"KW",
         axisLabelUseCanvas: true
         }]
         */
    });

    function showTooltip(x, y, contents) {
        $('<div id="tooltip">' + contents + '</div>').css( {
            position: 'absolute',
            display: 'none',
            top: y + 5,
            left: x + 5,
            border: '1px solid #fdd',
            padding: '2px',
            'background-color': '#dfeffc',
            opacity: 0.80
        }).appendTo("body").fadeIn(200);
    }

    var previousPoint = null;
    $("#day_sincos").bind("plothover", function (event, pos, item) {
        $("#x").text(pos.x.toFixed(2));
        $("#y").text(pos.y.toFixed(2));

        if (item) {
            if (previousPoint != item.dataIndex) {
                previousPoint = item.dataIndex;

                $("#tooltip").remove();
                var x = item.datapoint[0].toFixed(2),
                    y = item.datapoint[1].toFixed(2);
                /**
                 * item.series.label + " of " + x + " = " + y);
                 * **/
                showTooltip(item.pageX, item.pageY,
                    item.series.label + ":  "  + y + "KW");
            }
        }
        else {
            $("#tooltip").remove();
            previousPoint = null;
        }
    });


/**
    $("#day_sincos").bind("plotclick", function (event, pos, item) {
        if (item) {
            $("#clickdata").text("You clicked point " + item.dataIndex + " in " + item.series.label + ".");
            plot.highlight(item.series, item.datapoint);
        }
    });
**/

    /* ---------- month chart ---------- */
    var m_make = [[1, 60.2],[2, 55.7],[3, 74.2],[4, 79.5],[5, 86.3],[6, 95.3]],
        m_cost = [[1, 450],[2, 512],[3, 410],[4, 389],[5, 523],[6, 563]];

    $.plot($("#month_sincos"), [
        {data: m_make, label: "每月发电量"},
        {data: m_cost, label: "每月耗电量"}
    ], {
        series: {
            lines: { show: true,
                lineWidth: 2
            },
            points: { show: true },
            shadowSize: 2
        },
        grid: { hoverable: true,
            clickable: true,
            tickColor: "#dddddd",
            borderWidth: 0
        },
        colors: ["#FA5833", "#2FABE9"]
        /*
         xaxis: {
         axisLabel: 'foo',
         axisLabelUseCanvas: true,
         axisLabelFontSizePixels: 12,
         axisLabelFontFamily: 'Arial'
         },
         yaxis: [{
         axisLabel:"KW",
         axisLabelUseCanvas: true
         }]
         */
    });


    //var previousPoint = null;
    $("#month_sincos").bind("plothover", function (event, pos, item) {
        $("#x").text(pos.x.toFixed(2));
        $("#y").text(pos.y.toFixed(2));

        if (item) {
            if (previousPoint != item.dataIndex) {
                previousPoint = item.dataIndex;

                $("#tooltip").remove();
                var x = item.datapoint[0].toFixed(2),
                    y = item.datapoint[1].toFixed(2);
                /**
                 * item.series.label + " of " + x + " = " + y);
                 * **/
                showTooltip(item.pageX, item.pageY,
                    item.series.label + ":  "  + y + "KW");
            }
        }
        else {
            $("#tooltip").remove();
            previousPoint = null;
        }
    });

});