<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
<link rel="stylesheet" type="text/css" href="../css/result.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
<title>상품 미리 보기</title>

</head>
<body style="padding:0;margin:0;">
	<div class="row" style="background: white;width:700px;margin:0;">
			<div class="col-md-2 col-lg-6" style="width:300px;">
				<div class="card">
					<div class="card-image">
						<figure class="image is-4by3">
							<img src="http://placehold.it/300x225" alt="">
						</figure>
					</div>
					<div class="card-content">
						<div class="content">
							<span class="tag is-dark">#Title</span>
						</div>
						<div class="content">
							<strong class="timestamp">Cost</strong>
						</div>
					</div>
				</div>
            </div>
            <div class="col-md-2 col-lg-6" style="width:400px;">
				<table class="table" id="overView">
					<tr>
						<th>제목</th>
						<td>[제목입력]</td>
					</tr>
					<tr>
                      	<th>기간</th>
                      	<td>[기간입력]</td>
                  	</tr>
                  	<tr>
                      	<th>경로</th>
                      	<td>[경로입력]</td>
                  	</tr>
                  	<tr>
                  		<th><center><a class="btn btn-info" role="button" href="#">상세보기 »</a></th></center>
                  	</tr>
              	</table>
			</div>
		</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>