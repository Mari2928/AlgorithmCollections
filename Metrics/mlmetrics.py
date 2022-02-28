def my_confusion_matrix(y_test, y_pred, classno):
    """
    Create a confusion matrix.
    
    Parameters
    ----------    
    y_test : list
    A list of label numbers of testing data.
    
    y_pred : list
    A list of predicted label numbers.
    
    classno : int
    The number of classes.
    
    Return
    ----------
    ndarray
    (n, n) NumPy array contains n dimensions of the confusion matrix.
    
    """  
    # create a matrix with entries equal to zero
    C = np.zeros((classno, classno), dtype= np.int)
    
    # go through each label
    for i in range(0, len(y_test)):
        # increment the matched position by 1        
        C[y_test[i], y_pred[i]] += 1
    
    return C
  
  
  def my_accuracy(y_test, y_pred):
    """
    Given truth labels and predicted labels, caluculate the accuracy score.
    
    Parameters
    ----------    
    y_test : list
    A list of label numbers of testing data.
    
    y_pred : list
    A list of predicted label numbers.
    
    Return
    ----------
    float
    The accuracy score.
    
    """  
    # put 1 in a new list where values are identical and 0 otherwise
    correct = np.where(y_test == y_pred, 1, 0)
    
    # total number of data points
    total = len(y_test)
    
    # sum all 1s and divide by total to derive accuracy score
    return sum(correct) / total
  
  
  def my_precision(y_test, y_pred):
    """
    Given truth classes and predicted classes, caluculate
    precision scores; how likely the positive prediction is correct.
    
    Parameters
    ----------    
    y_test : list
    A list of class numbers of testing data.
    
    y_pred : list
    A list of predicted class numbers.
    
    Return
    ----------
    list
    A list of precision scores.
    
    """ 
    # a list of classes
    classes = np.unique(y_test)
    
    # a list with entries equal to zero
    precision = np.zeros(classes.shape)
    
    # create a confusion matrix
    C = my_confusion_matrix(y_test, y_pred, len(classes))
    
    # go through each class
    for i in classes:       
        # calculate how likely the positive prediction is correct
        precision[i] = C[i, i] / sum(C[:,i])
    
    return precision
  
  
  def my_recall(y_test, y_pred):
    """
    Given truth classes and predicted classes, 
    caluculate recall scores; the accuracy score by class.
    
    Parameters
    ----------    
    y_test : list
    A list of class numbers of testing data.
    
    y_pred : list
    A list of predicted class numbers.
    
    Return
    ----------
    list
    A list of recall scores.
    
    """ 
    # a list of classes
    classes = np.unique(y_test)
    
    # a list with entries equal to zero
    recall = np.zeros(classes.shape)
    
    # create a confusion matrix
    C = my_confusion_matrix(y_test, y_pred, len(classes))
    
    # go through each class
    for i in classes:
        # calculate the accuracy by class
        recall[i] = C[i, i] / sum(C[i,:])
    
    return recall
  
  
  
# test evaluation code

from sklearn.model_selection import train_test_split

# split to train and test
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# predit class using my knn classifier with 10 neighbors
y_pred = mykNN(X_train, y_train, X_test, 10, 'euclidean')

# print the ground truth and my predictions
print('preds: %s' % y_pred)
print('truth: %s' % y_test)

# print my confusion matrix
print(my_confusion_matrix(y_test, y_pred, len(np.unique(y))))

# print the evaluation scores
print('classes: %s' % np.unique(y_pred))
print('accuracy: %.2f' % my_accuracy(y_test, y_pred))
print('my precision: %s' % my_precision(y_test, y_pred))
print('my recall: %s' % my_recall(y_test, y_pred))
