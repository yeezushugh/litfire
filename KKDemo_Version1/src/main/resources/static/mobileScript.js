/* Document ready render display    */
$(document).ready(function (){

    // Enable  passive event listener



    // Define size attribute for
    let mainContainerHeight;
    let mainContainerWidth;

    // Define Flag for Function Bar show status
    let mainReminderDetailContainerFlag = false;

    // reminderContentCaption Margin left offset to align width
    let reminderContentCaptionMarginOffset=8;
    // Render display based on screen width
    // Default: 1
    // Mobile:  2
    // Pad:     3
    // PC:      4
    let renderFlag = 1;
    if(0 < screen.availWidth <= 600){
        renderFlag = 2;
    }else if(600 < screen.availWidth <= 1080){
        renderFlag = 3;
    }else if(1080 < screen.availWidth){
        renderFlag = 4;
    }


    // Render Data list  for Test
    let games = new Array();
    games[0] = "World of Warcraft";
    games[1] = "World of Warcraft";
    games[2] = "World of Warcraft";
    games[3] = "World of Warcraft";
    games[4] = "World of Warcraft";
    games[5] = "World of Warcraft";
    games[6] = "World of Warcraft";
    games[7] = "World of Warcraft";
    games[8] = "World of Warcraft";

    let times = new Array();
    times[0] = "2.12.2002";
    times[1] = "2.12.2002";
    times[2] = "2.12.2002";
    times[3] = "2.12.2002";
    times[4] = "2.12.2002";
    times[5] = "2.12.2002";
    times[6] = "2.12.2002";
    times[7] = "2.12.2002";
    times[8] = "2.12.2002";
    times[9] = "2.12.2002";


    /* Render Display and Data when document is ready */
    $(document).ready(function(){
        let list = "";
        for(i=0; i<games.length; i++){
            list +=
                "<div class='reminderItem' id='"+i+"'>"+
                    "<div class='reminderBaseContainer'>"+
                        "<div class='reminderFunctionBarDelete'></div>"+
                    "</div>"+
                    "<div class='reminderContentContainer'>"+
                        "<div class='reminderIconContainer'>"+
                            "<div class='reminderIcon'></div>"+
                        "</div>"+
                        "<div class='reminderContent'>"+
                            "<div class='reminderContentCaption'>"+
                                "<div class='reminderCaptionText' id='"+"Caption"+i+"'>"+games[i]+"</div>"+
                            "</div>"+
                            "<div class='reminderContentTime'>"+times[i]+"</div>"+
                        "</div>"+
                        "<div class='reminderFlagContainer'>"+"</div>"+
                    "</div>"+
                    "<div class='breaker'>"+"</div>"+
                "</div>"
                ;
        }
        $("#reminderList").append(list);

        /*for(i=0; i<games.length; i++){
            let name="Caption"+i;
            $("#"+name+"").text(games[i]);
        }*/
    // Render display
    switch (renderFlag) {
        case 1:
            mainContainerHeight = $(document).height()-$(".mainHeader").height()-$(".mainFunctionBar").height();
            mainContainerWidth = $(document).width();
            $(".mainContainer").attr("width",mainContainerWidth);
            $(".mainContainer").attr("height",mainContainerHeight);
            break;
        case 2:
            let viewPortHeight=document.documentElement.clientHeight;
            $(".mainContainer").height(viewPortHeight-$(".mainHeader").height()-$(".mainFunctionBar").height());
            $(".reminderListContainer").height($(".mainContainer").height());
            $(".reminderContent").width($(document).width()-$(".reminderIconContainer").width()-$(".reminderFlagContainer").width())
            $(".reminderContentCaption").width($(document).width()-$(".reminderIconContainer").width()-$(".reminderFlagContainer").width()-reminderContentCaptionMarginOffset)
            $(".reminderContentTime").width($(document).width()-$(".reminderIconContainer").width()-$(".reminderFlagContainer").width()-reminderContentCaptionMarginOffset)
            $(".mainReminderWholeContainer").hide();
            $(".addReminderWholeContainer").hide();
            $(".detailToggleContainer").hide();
            $(".addReminderDetailContainer .DetailTime .dateInput").width($(document).width()*0.8);
            $(".addReminderDetailContainer").height($(".addReminderWholeContainer").height()-$(".addReminderHeader").height()-$(".addReminderDetailFooterContainer").height());
            $(".mainReminderMask").height(viewPortHeight-$(".mainReminderDetailContainer").height())
            break;
        case 3:
            mainContainerHeight = $(document).height()-$(".mainHeader").height()-$(".mainFunctionBar").height();
            mainContainerWidth = $(document).width();
            $(".mainContainer").height(mainContainerHeight);
            $(".reminderContent").width($(document).width()-$(".reminderIconContainer").width()-$(".reminderFlagContainer").width())
            break;
        case 4:
            mainContainerHeight = $(document).height()-$(".mainHeader").height()-$(".mainFunctionBar").height();
            mainContainerWidth = $(document).width();
            $(".mainContainer").height(mainContainerHeight);
            break;
        default:
    }


    });

    /* Functions for click events*/
    /* Click event for reminderContent */
    /* Append element requires using on*/
    $(document).on('click', '.reminderContent', function(){
        /* Show mainReminderDetailContainer*/
        $(".mainReminderWholeContainer").show();
        $(".mainReminderWholeContainer").animate({bottom:"0px"})
    });

    /* Hide mainReminderWholeContainer */
    $(document).on('click', '.mainReminderMask', function(){
        /* Show mainReminderDetailContainer*/
        $(".mainReminderWholeContainer").animate({bottom:"-"+$(document).height()+"px"},{duration:300})
        $(".mainReminderWholeContainer").fadeOut();
    });

    /* Slide Reminder item to delete*/
    (function slideReminder(){
        /* x coordinate for touch start and end*/
        let start_x;
        let end_x;
        let start_y;
        let end_y

        let delete_button_width = 300;
        /* IF the slide movement is success,*/
        /* Default false*/
        let touch_flag = false;

        // Touch starts
        $(document).on('touchstart', '.reminderContentContainer', function(e){
            if(e.originalEvent.targetTouches){
                start_x = e.originalEvent.targetTouches[0].pageX;
                start_y = e.originalEvent.targetTouches[0].pageY;
            }else {
                start_x = e.pageX;
                start_y = e.pageY;
            }
        });

        // Touch on going
        $(document).on('touchmove', '.reminderContentContainer', function(e){

            let offset;

            // Get touch end coordinate
            if(e.originalEvent.targetTouches){
                end_x = e.originalEvent.targetTouches[0].pageX;
                offset = start_x - end_x;
            }else {
                end_x = e.pageX;
                offset = start_x - end_x;
            }

            // Start moving and not move less than the button width
            if(20< offset){
                // Render animation
                $(this).css("right",offset+"px");
                touch_flag = true;
            }else {
                return;
            }

        });

        // Touch ended
        $(document).on('touchend', '.reminderContentContainer', function(e){

            let offset = start_x - end_x;

            // If touch success
            if (touch_flag == true){
                if(offset>0){
                    $(this).animate({right: 100+"px"},300);
                }
                else {
                    $(this).animate({right: 0+"px"},300);
                }
            }else return;
            touch_flag = false;
        });
        // Touch on delete button
        $(document).on('click', '.reminderFunctionBarDelete', function(e){
            alert("Yeah Touched!");
        });

    })();


    /* Main footer function bar  button *******************************************************************************/
    $(".mainFunctionBarButton").click(function (){
        //$(".addReminderWholeContainer").show();
        $(".addReminderWholeContainer").show();
        $(".addReminderWholeContainer").animate({bottom:"0px"},200)
    });

    /* Click on close button and hide *********************************************************************************/
    $(".addReminderHeaderClose").click(function (){
        $(".addReminderWholeContainer").animate({bottom:"-"+$(document).height()+"px"},{duration:200})
        $(".addReminderWholeContainer").fadeOut();
    });

    /* Add reminder page toggle ***************************************************************************************/
    $(".toggleButton").click(function (){
        if($(".detailToggleContainer").is(':visible')){
            $(".addReminderDetailContainer").height($(".addReminderDetailContainer").height()-$(".detailToggleContainer").height());
        }else {
            $(".addReminderDetailContainer").height($(".addReminderDetailContainer").height()+$(".detailToggleContainer").height());
        }
        $(".detailToggleContainer").toggle("fold");
    })
})


// Convert rem to px
function convertRemToPixels(rem) {
    return rem * parseFloat(getComputedStyle(document.documentElement).fontSize);
}