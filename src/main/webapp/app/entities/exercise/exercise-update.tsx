import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IUser } from 'app/shared/model/user.model';
import { getUsers } from 'app/modules/administration/user-management/user-management.reducer';
import { getEntity, updateEntity, createEntity, reset } from './exercise.reducer';
import { IExercise } from 'app/shared/model/exercise.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IExerciseUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IExerciseUpdateState {
  isNew: boolean;
  exerciseuserId: string;
}

export class ExerciseUpdate extends React.Component<IExerciseUpdateProps, IExerciseUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      exerciseuserId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (!this.state.isNew) {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getUsers();
  }

  saveEntity = (event, errors, values) => {
    values.createdTime = new Date(values.createdTime);

    if (errors.length === 0) {
      const { exerciseEntity } = this.props;
      const entity = {
        ...exerciseEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/exercise');
  };

  render() {
    const { exerciseEntity, users, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="ecoLearningApp.exercise.home.createOrEditLabel">
              <Translate contentKey="ecoLearningApp.exercise.home.createOrEditLabel">Create or edit a Exercise</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : exerciseEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="exercise-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="fileNameLabel" for="fileName">
                    <Translate contentKey="ecoLearningApp.exercise.fileName">File Name</Translate>
                  </Label>
                  <AvField id="exercise-fileName" type="text" name="fileName" />
                </AvGroup>
                <AvGroup>
                  <Label id="imageUrlLabel" for="imageUrl">
                    <Translate contentKey="ecoLearningApp.exercise.imageUrl">Image Url</Translate>
                  </Label>
                  <AvField id="exercise-imageUrl" type="text" name="imageUrl" />
                </AvGroup>
                <AvGroup>
                  <Label id="createdTimeLabel" for="createdTime">
                    <Translate contentKey="ecoLearningApp.exercise.createdTime">Created Time</Translate>
                  </Label>
                  <AvInput
                    id="exercise-createdTime"
                    type="datetime-local"
                    className="form-control"
                    name="createdTime"
                    value={isNew ? null : convertDateTimeFromServer(this.props.exerciseEntity.createdTime)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="exerciseTypeLabel" for="exerciseType">
                    <Translate contentKey="ecoLearningApp.exercise.exerciseType">Exercise Type</Translate>
                  </Label>
                  <AvField id="exercise-exerciseType" type="text" name="exerciseType" />
                </AvGroup>
                <AvGroup>
                  <Label for="exerciseuser.login">
                    <Translate contentKey="ecoLearningApp.exercise.exerciseuser">Exerciseuser</Translate>
                  </Label>
                  <AvInput id="exercise-exerciseuser" type="select" className="form-control" name="exerciseuserId">
                    <option value="" key="0" />
                    {users
                      ? users.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.login}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/exercise" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />&nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />&nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  users: storeState.userManagement.users,
  exerciseEntity: storeState.exercise.entity,
  loading: storeState.exercise.loading,
  updating: storeState.exercise.updating,
  updateSuccess: storeState.exercise.updateSuccess
});

const mapDispatchToProps = {
  getUsers,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ExerciseUpdate);
