
        <style type="text/css">

            ul{

                padding: 0;

                list-style: none;

                background:  #5bc0de;

            }

            ul li{

                display: inline-block;

                position: relative;

                line-height: 30px;

                text-align: left;

            }

            ul li a{

                display: block;

                padding: 8px 25px;

                color:white;

                font-weight: bold;

                text-decoration: none;

            }

            ul li a:hover{

                color:  #5bc0de;
                text-decoration: none;
                background: white;

            }

            ul li ul.dropdown{

                min-width: 150%; /* Set width of the dropdown */

                background: #5bc0de;


                display: none;

                position: absolute;

                z-index: 999;

                left: 0;

            }

            ul li:hover ul.dropdown{

                display: block; /* Display the dropdown */

            }

            ul li ul.dropdown li{

                display: block;

            }

        </style>

    </head>

    <body class="container" ng-app="myapp">

        <ul>

            <li><a href="javascript:void(0)" id="home"></a></li>

            <li><a href="#"></a></li>

            <li>

                <a href="#"></a>

                <ul class="dropdown">

                    <li><a href="${SITE_URL}/account/openaccount/" id="openaccount"></a></li>

                    <li><a href="javascript:void(0)" id="searchaccount"></a></li>

                    <li><a href="#"></a></li>

                </ul>

            </li>

            <li>
                <a href="#"></a>
                <ul class="dropdown">
                    <li><a href="javascript:void(0)" id="deposit"></a></li>

                    <li><a href="javascript:void(0)" id="withdraw"></a></li>

                </ul>

            </li>

        </ul>

