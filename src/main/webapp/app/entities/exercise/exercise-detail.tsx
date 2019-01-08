import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './exercise.reducer';
import { IExercise } from 'app/shared/model/exercise.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IExerciseDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ExerciseDetail extends React.Component<IExerciseDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { exerciseEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="ecoLearningApp.exercise.detail.title">Exercise</Translate> [<b>{exerciseEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="fileName">
                <Translate contentKey="ecoLearningApp.exercise.fileName">File Name</Translate>
              </span>
            </dt>
            <dd>{exerciseEntity.fileName}</dd>
            <dt>
              <span id="imageUrl">
                <Translate contentKey="ecoLearningApp.exercise.imageUrl">Image Url</Translate>
              </span>
            </dt>
            <dd>{exerciseEntity.imageUrl}</dd>
            <dt>
              <span id="createdTime">
                <Translate contentKey="ecoLearningApp.exercise.createdTime">Created Time</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={exerciseEntity.createdTime} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="exerciseType">
                <Translate contentKey="ecoLearningApp.exercise.exerciseType">Exercise Type</Translate>
              </span>
            </dt>
            <dd>{exerciseEntity.exerciseType}</dd>
            <dt>
              <Translate contentKey="ecoLearningApp.exercise.exerciseuser">Exerciseuser</Translate>
            </dt>
            <dd>{exerciseEntity.exerciseuserLogin ? exerciseEntity.exerciseuserLogin : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/exercise" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/exercise/${exerciseEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ exercise }: IRootState) => ({
  exerciseEntity: exercise.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ExerciseDetail);
